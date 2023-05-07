package com.zxcv5595.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@EntityScan(basePackages = ["com.zxcv5595.domain"])
@ComponentScan(basePackages = ["com.zxcv5595"])
@EnableCaching
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}