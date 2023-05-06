package com.zxcv5595.api.test

class TestDto {
    data class UserInfoDto(
            val userKey: String,
            val userRegistrationNumber: String,
            val userName: String,
            val userIncomeAmount: Long
    )

}