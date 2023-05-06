package com.zxcv5595.api.loan.request

import com.zxcv5595.domain.domain.UserInfo

interface LoanRequestService {
    fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanResponseDto

    fun saveUserInfo(
            userInfoDto: UserInfoDto
    ):UserInfo

    fun loanRequestReview(userKey: String)

}