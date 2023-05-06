package com.zxcv5595.api.loan.request

import com.zxcv5595.api.loan.GenerateKey
import com.zxcv5595.api.loan.encrypt.EncryptComponent
import com.zxcv5595.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
        private val generateKey: GenerateKey,
        private val userInfoRepository: UserInfoRepository,
        private val encryptComponent: EncryptComponent
) : LoanRequestService {
    override fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanResponseDto {
        val userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber=
                encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey))

        loanRequestReview(userKey)

        return LoanRequestDto.LoanResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
            userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(
            userKey: String) {
        TODO("Not yet implemented")
    }
}