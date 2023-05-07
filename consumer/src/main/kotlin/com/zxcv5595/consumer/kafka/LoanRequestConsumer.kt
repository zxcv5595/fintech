package com.zxcv5595.consumer.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.zxcv5595.consumer.service.LoanRequestService
import com.zxcv5595.kafka.dto.LoanRequestDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class LoanRequestConsumer(
        private val objectMapper: ObjectMapper,
        private val loanRequestService:LoanRequestService
) {
    @KafkaListener(topics = ["loan_request"], groupId = "fintech")
    fun loanRequestTopicConsumer(message:String){
        val loanRequestKafkaDto = objectMapper.readValue(message,LoanRequestDto::class.java)

        loanRequestService.loanRequest(loanRequestKafkaDto)
    }
}