package com.zxcv5595.api.loan.review

interface LoanReviewService {
    fun loanReviewMain(userKey:String):LoanReviewDto.LoanReviewResponseDto
    fun getLoanResult(userKey: String):LoanReviewDto.LoanReview
}