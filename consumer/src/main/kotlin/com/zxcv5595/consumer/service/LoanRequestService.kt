package com.zxcv5595.consumer.service

import com.zxcv5595.consumer.dto.ReviewResponseDto
import com.zxcv5595.domain.domain.LoanReview
import com.zxcv5595.domain.repository.LoanReviewRepository
import com.zxcv5595.kafka.dto.LoanRequestDto
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class LoanRequestService(
        private val loanReviewRepository: LoanReviewRepository
) {
    companion object{
        const val cssUrl = "http://localhost:8081/css/api/v1/request"
    }
    fun loanRequest(loanRequestDto: LoanRequestDto) {

        val reviewResult = loanRequestToCb(loanRequestDto)

        saveLoanData(reviewResult.toLoanReviewEntity())
    }

    private fun loanRequestToCb(loanRequestDto: LoanRequestDto):ReviewResponseDto{
        val restTemplate =RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(1000))
                .setReadTimeout(Duration.ofMillis(1000))
                .build()

        return restTemplate.postForEntity(cssUrl, loanRequestDto, ReviewResponseDto::class.java).body!!
    }
    private fun saveLoanData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)


}