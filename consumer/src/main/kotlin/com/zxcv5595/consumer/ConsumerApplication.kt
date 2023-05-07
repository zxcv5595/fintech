package com.zxcv5595.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(basePackages = ["com.zxcv5595.domain"])
class ConsumerApplication

fun main(args: Array<String>){
    runApplication<ConsumerApplication>(*args)
}