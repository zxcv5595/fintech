package com.zxcv5595.api.aop

import com.zxcv5595.api.loan.encrypt.Encrypt
import com.zxcv5595.api.loan.encrypt.EncryptComponent
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import java.util.*

@Component
@Aspect
class EncryptionAspect(
        private val encryptComponent: EncryptComponent
) {
    @Around("execution(* org.springframework.data.repository.CrudRepository+.save(..)) && args(entity)")
    fun encryptOnSave(joinPoint: ProceedingJoinPoint, entity: Any): Any {
        val clazz = entity::class.java
        val encryptFields = clazz.declaredFields.filter { it.isAnnotationPresent(Encrypt::class.java) }
        encryptFields.forEach { field ->
            field.isAccessible = true
            val fieldValue = field.get(entity) as String
            val encryptedValue = encryptComponent.encryptString(fieldValue)
            field.set(entity, encryptedValue)
        }
        return joinPoint.proceed(joinPoint.args)
    }

    @Around("execution(* org.springframework.data.repository.CrudRepository+.findById(..)) && args(id)")
    fun decryptOnFindById(joinPoint: ProceedingJoinPoint, id: Any): Any? {
        val entity = joinPoint.proceed() as Optional<*>
        if (entity.isPresent) {
            val clazz = entity.get()::class.java
            val encryptFields = clazz.declaredFields.filter { it.isAnnotationPresent(Encrypt::class.java) }
            encryptFields.forEach { field ->
                field.isAccessible = true
                val fieldValue = field.get(entity.get()) as String
                val decryptedValue = encryptComponent.decryptString(fieldValue)
                field.set(entity.get(), decryptedValue)
            }
        }
        return entity.orElse(null)
    }
}
