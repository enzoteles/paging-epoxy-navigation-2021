package com.example.koroutinesmvvm.domain.datasource

import com.example.koroutinesmvvm.data.remote.GetCharacterByIdDTO
import com.example.koroutinesmvvm.data.remote.GetCharacterPageDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShareDataSource {
    @GET("character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ): Response<GetCharacterByIdDTO>

    @GET("character")
    suspend fun getCharactersPage(
        @Query("page") pageIndex: Int
    ): Response<GetCharacterPageDTO>
}