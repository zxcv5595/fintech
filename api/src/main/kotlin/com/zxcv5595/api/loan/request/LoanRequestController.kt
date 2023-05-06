package com.zxcv5595.api.loan.request

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class LoanRequestController(
        private val loanRequestServiceImpl: LoanRequestServiceImpl
) {
    @PostMapping("/request")
    fun loanRequest(
            @RequestBody loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): ResponseEntity<LoanRequestDto.LoanResponseDto> {
       return ResponseEntity.ok(
                loanRequestServiceImpl.loanRequestMain(loanRequestInputDto)
        )
    }
}