package com.zxcv5595.css.controller

import com.zxcv5595.css.dto.LoanRequestDto
import com.zxcv5595.css.dto.LoanResultDto
import com.zxcv5595.css.service.LoanReviewService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/css/api/v1")
class LoanReceiveController(
        private val loanReviewService: LoanReviewService
) {

    @PostMapping("/request")
    fun loanRequest(
            @RequestBody loanRequestInputDto: LoanRequestDto.RequestInputDto
    ): LoanResultDto.ResponseDto =
            loanReviewService.loanReview(loanRequestInputDto)

}