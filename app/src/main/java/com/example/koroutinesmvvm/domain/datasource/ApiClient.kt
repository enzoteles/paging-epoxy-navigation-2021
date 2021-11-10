package com.example.koroutinesmvvm.domain.datasource

import com.example.koroutinesmvvm.common.GenericResponse
import com.example.koroutinesmvvm.data.remote.GetCharacterByIdDTO
import com.example.koroutinesmvvm.domain.datasource.ShareDataSource
import retrofit2.Response
import java.lang.Exception

class ApiClient(
    private val shareDataSource: ShareDataSource
) {
    suspend fun getCharacterById(characterId: Int): GenericResponse<GetCharacterByIdDTO> {
        return safeApiCall { shareDataSource.getCharacterById(characterId) }
    }

    private inline fun<T> safeApiCall(apiCall: ()-> Response<T>): GenericResponse<T>{
        return try {
            GenericResponse.success(apiCall.invoke())
        }catch (e: Exception){
            GenericResponse.failed(e)
        }
    }
}