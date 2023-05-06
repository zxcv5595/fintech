package com.zxcv5595.api.loan.review

import com.zxcv5595.api.exception.CustomException
import com.zxcv5595.api.exception.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackageClasses = [LoanReviewController::class])
class LoanReviewControllerAdvice {
    @ExceptionHandler(CustomException::class)
    fun customExceptionHandler(customException: CustomException)=
    ErrorResponse(customException).toResponseEntity()

}