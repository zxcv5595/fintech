package com.zxcv5595.consumer.dto

import com.zxcv5595.domain.domain.LoanReview
import com.zxcv5595.kafka.dto.LoanRequestDto

data class ReviewResponseDto(
        val userKey:String,
        val interest: Double,
        val limitAmount: Long
){
    fun toLoanReviewEntity():LoanReview= LoanReview(
            userKey = userKey,
            loanInterest = interest,
            loanLimitedAmount = limitAmount
    )
}