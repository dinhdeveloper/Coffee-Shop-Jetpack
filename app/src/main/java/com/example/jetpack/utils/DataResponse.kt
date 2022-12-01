package com.example.jetpack.utils

sealed class DataResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : DataResponse<T>(data = data)
    class Error<T>(errorMessage: String) : DataResponse<T>(message = errorMessage)
    class Loading<T> : DataResponse<T>()
}
