package com.antonharbatovich.financeapp.domain.entity

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Result<T>(data = data)
    class Error<T>(errorMessage: String) : Result<T>(message = errorMessage)
    class Loading<T> : Result<T>()
    class UnknownError<T> : Result<T>()
}