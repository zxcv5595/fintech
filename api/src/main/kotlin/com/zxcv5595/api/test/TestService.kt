package com.zxcv5595.api.test

import com.zxcv5595.domain.domain.UserInfo
import com.zxcv5595.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class TestService(
        private val userInfoRepository: UserInfoRepository
) {
    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey).toDto()

    fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistrationNumber, userName, userIncomeAmount)
}