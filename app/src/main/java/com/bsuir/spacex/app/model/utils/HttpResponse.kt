package com.bsuir.spacex.app.model.utils

import java.util.*

data class HttpResponse(
    val timeStamp: Date,
    val httpStatusCode: Int,
    val httpStatus: HttpStatus,
    val reason: String,
    val message: String
)
