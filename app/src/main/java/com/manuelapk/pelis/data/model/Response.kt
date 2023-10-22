package com.manuelapk.pelis.data.model

sealed class Response<out T> {
    data class Successful<T>(
        val data: T
    ) : Response<T>()

    data class Error<T>(
        val message: String
    ) : Response<T>()
}