package com.example.koroutinesmvvm.common

import retrofit2.Response
import java.lang.Exception

data class GenericResponse<T>(
    val status: Status,
    val data: Response<T>?,
    val exception: Exception?
){
    companion object{
        fun <T>success(data:Response<T>): GenericResponse<T>{
            return GenericResponse(
                status = Status.Success,
                data = data,
                exception = null
            )
        }

        fun <T>failed(exception: Exception): GenericResponse<T>{
            return GenericResponse(
                status = Status.Failure,
                data = null,
                exception = exception
            )
        }
    }

    sealed class Status{
        object Success: Status()
        object Failure: Status()
    }

    val failed: Boolean
        get() = this.status == Status.Failure

    val isSuccessful: Boolean
        get() = failed.not() && this.data?.isSuccessful == true

    val body: T?
        get() = this.data?.body()

}
