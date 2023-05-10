package com.zxcv5595.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.*

@Configuration
@EnableKafka
class KafkaConfig {

    companion object {
        const val bootstrapServer = "kafka:9092"
    }


    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val configurationProperties = HashMap<String, Any>()
        configurationProperties[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        configurationProperties[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configurationProperties[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java

        return DefaultKafkaProducerFactory(configurationProperties)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }

//    @Bean
//    fun consumerFactory(): ConsumerFactory<String, String> {
//        val configurationProperties = HashMap<String, Any>()
//        configurationProperties[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
//        configurationProperties[ConsumerConfig.GROUP_ID_CONFIG] = "fintech"
//        configurationProperties[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"
//        configurationProperties[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
//        configurationProperties[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
//
//        val bootstrapServers: String? = configurationProperties[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG].to()
//        val groupId: String? = configurationProperties[ConsumerConfig.GROUP_ID_CONFIG].to()
//        val autoOffsetReset: String? = configurationProperties[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG].to()
//        val keyDeserializerClass: Class<*>? = configurationProperties[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG].to()
//        val valueDeserializerClass: Class<*>? = configurationProperties[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG].to()
//
//        return DefaultKafkaConsumerFactory<String, String>(
//                mapOf(
//                        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
//                        ConsumerConfig.GROUP_ID_CONFIG to groupId,
//                        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to autoOffsetReset,
//                        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to keyDeserializerClass,
//                        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to valueDeserializerClass
//                )
//        )
//    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        val configurationProperties = HashMap<String, Any>()
        configurationProperties[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        configurationProperties[ConsumerConfig.GROUP_ID_CONFIG] = "fintech"
        configurationProperties[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"
        configurationProperties[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configurationProperties[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java

        return DefaultKafkaConsumerFactory(configurationProperties)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = consumerFactory()
        return factory

    }
}

//inline fun <reified T> Any?.to(defaultValue: T? = null): T? {
//    if (this == null) return defaultValue
//    if (this is T) return this
//    if (this is String && String::class != T::class) {
//        if (T::class == Int::class) {
//            return this.toIntOrNull() as? T ?: defaultValue
//        } else if (T::class == Long::class) {
//            return this.toLongOrNull() as? T ?: defaultValue
//        } else if (T::class == Double::class) {
//            return this.toDoubleOrNull() as? T ?: defaultValue
//        } else if (T::class == Boolean::class) {
//            return this.toBoolean() as? T ?: defaultValue
//        }
//    }
//    throw IllegalArgumentException("Cannot cast $this to ${T::class}.")
//}
