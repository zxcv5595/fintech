package com.zxcv5595.api.exception

import org.springframework.http.HttpStatus

enum class CustomErrorCode(
        val statusCode:HttpStatus,
        val errorCode: String,
        val errorMessage:String
) {
    REQUEST_NOT_FOUND(HttpStatus.BAD_REQUEST,"REQUEST_NOT_FOUND","result not found")
}