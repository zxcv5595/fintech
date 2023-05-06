package com.zxcv5595.api.loan.request

class LoanRequestDto {
    data class LoanRequestInputDto(
            val userName: String,
            val userIncomeAmount: Long,
            var userRegistrationNumber: String
    ) {
        fun toUserInfoDto(userKey: String) =
                UserInfoDto(
                        userKey, userName, userRegistrationNumber, userIncomeAmount
                )
    }

    data class LoanResponseDto(
            val userKey: String
    )
}