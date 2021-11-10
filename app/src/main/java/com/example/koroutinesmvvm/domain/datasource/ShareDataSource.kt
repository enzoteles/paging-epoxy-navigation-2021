package com.example.koroutinesmvvm.domain.datasource

import com.example.koroutinesmvvm.data.remote.GetCharacterByIdDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ShareDataSource {
    @GET("character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ): Response<GetCharacterByIdDTO>
}