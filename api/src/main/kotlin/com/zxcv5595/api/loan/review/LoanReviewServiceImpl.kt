package com.zxcv5595.api.loan.review

import com.zxcv5595.api.exception.CustomErrorCode
import com.zxcv5595.api.exception.CustomException
import com.zxcv5595.domain.domain.LoanReview
import com.zxcv5595.domain.repository.LoanReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
        private val loanReviewRepository: LoanReviewRepository
) : LoanReviewService {
    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {


        return LoanReviewDto.LoanReviewResponseDto(
                userKey = userKey,
                loanResult = getLoanResult(userKey)?.toResponseDto()
                        ?: throw CustomException(CustomErrorCode.REQUEST_NOT_FOUND)
        )
    }

    override fun getLoanResult(userKey: String) = loanReviewRepository.findByUserKey(userKey)

    private fun LoanReview.toResponseDto() =
            LoanReviewDto.LoanResult(
                    userLimitAmount = this.loanLimitedAmount,
                    userLoanInterest = this.loanInterest
            )

}