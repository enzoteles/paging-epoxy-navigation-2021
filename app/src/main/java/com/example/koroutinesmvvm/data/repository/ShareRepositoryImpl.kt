package com.example.koroutinesmvvm.data.repository

import com.example.koroutinesmvvm.common.NetworkLayer
import com.example.koroutinesmvvm.data.remote.GetCharacterByIdDTO
import com.example.koroutinesmvvm.domain.ShareRepository

class ShareRepositoryImpl: ShareRepository {
    override suspend fun getCharacterById(characterId: Int): GetCharacterByIdDTO? {
        //fonte de dados é o NetworkLayer
        val request  = NetworkLayer.apiClient.getCharacterById(characterId)


        if(request.failed){
            return null
        }
        if(request.isSuccessful.not()){
            return null
        }
        return request.body
    }
}