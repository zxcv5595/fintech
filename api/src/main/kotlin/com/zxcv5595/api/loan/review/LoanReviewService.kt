package com.zxcv5595.api.loan.review

import com.zxcv5595.domain.domain.LoanReview

interface LoanReviewService {
    fun loanReviewMain(userKey:String):LoanReviewDto.LoanReviewResponseDto
    fun getLoanResult(userKey: String):LoanReview?
}