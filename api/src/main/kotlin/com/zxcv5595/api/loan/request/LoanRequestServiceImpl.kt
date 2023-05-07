package com.zxcv5595.api.loan.request

import com.zxcv5595.api.loan.GenerateKey
import com.zxcv5595.api.loan.encrypt.EncryptComponent
import com.zxcv5595.domain.repository.UserInfoRepository
import com.zxcv5595.kafka.enum.KafkaTopic
import com.zxcv5595.kafka.producer.LoanRequestSender
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
        private val generateKey: GenerateKey,
        private val userInfoRepository: UserInfoRepository,
        private val encryptComponent: EncryptComponent,
        private val loanRequestSender: LoanRequestSender
) : LoanRequestService {
    override fun loanRequestMain(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanResponseDto {
        val userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
                encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        val userInfoDto = loanRequestInputDto.toUserInfoDto(userKey)

        saveUserInfo(userInfoDto)

        loanRequestReview(userInfoDto)

        return LoanRequestDto.LoanResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
            userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(userInfoDto: UserInfoDto) {
        loanRequestSender.sendMessage(
                KafkaTopic.LOAN_REQUEST,
                userInfoDto.toLoanRequestKafkaDto()
        )
    }
}