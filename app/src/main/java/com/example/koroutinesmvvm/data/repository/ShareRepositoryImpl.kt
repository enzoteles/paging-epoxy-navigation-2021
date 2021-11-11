package com.example.koroutinesmvvm.data.repository

import com.example.koroutinesmvvm.common.NetworkLayer
import com.example.koroutinesmvvm.data.remote.toGetCharacterByIdMapper
import com.example.koroutinesmvvm.domain.repo.ShareRepository
import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper

class ShareRepositoryImpl: ShareRepository {
    //no repository eu estou usando o mapper
    override suspend fun getCharacterById(characterId: Int): GetCharacterByIdMapper? {
        //fonte de dados é o NetworkLayer
        val request  = NetworkLayer.apiClient.getCharacterById(characterId)


        if(request.failed){
            return null
        }
        if(request.isSuccessful.not()){
            return null
        }
        //estou usando o mapper
        return request.body?.toGetCharacterByIdMapper()
    }
}

