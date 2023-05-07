package com.zxcv5595.css.service

import com.zxcv5595.css.dto.LoanRequestDto
import com.zxcv5595.css.dto.LoanResultDto
import org.springframework.stereotype.Service

@Service
class LoanReviewService {

    fun loanReview(loanRequestDto: LoanRequestDto.RequestInputDto): LoanResultDto.ResponseDto {
        if (loanRequestDto.userIncomeAmount < 0) throw RuntimeException("invalid userIncomeAmount Param")
        if (loanRequestDto.userIncomeAmount < 10000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey,0.0, 10000000)
        if (loanRequestDto.userIncomeAmount < 20000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey,10.0, 20000000)
        if (loanRequestDto.userIncomeAmount < 30000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey,9.0, 30000000)
        if (loanRequestDto.userIncomeAmount < 40000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey,8.0, 40000000)
        if (loanRequestDto.userIncomeAmount < 50000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey,7.0, 50000000)
        if (loanRequestDto.userIncomeAmount >= 50000000) return LoanResultDto.ResponseDto(loanRequestDto.userKey,6.0, 60000000)
        throw RuntimeException("invalid userIncomeAmount Param")
    }
}