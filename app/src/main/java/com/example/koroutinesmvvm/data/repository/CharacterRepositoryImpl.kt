package com.example.koroutinesmvvm.data.repository

import com.example.koroutinesmvvm.common.NetworkLayer
import com.example.koroutinesmvvm.data.remote.toGetCharacterPageMapper
import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper
import com.example.koroutinesmvvm.domain.model.GetCharacterPageMapper
import com.example.koroutinesmvvm.domain.repo.CharacterRepository

class CharacterRepositoryImpl: CharacterRepository {

    override  suspend fun getCharacterList(pageIndex: Int): GetCharacterPageMapper? {
        val request = NetworkLayer.apiClient.getCharactersPage(pageIndex)
        if(request.failed || request.isSuccessful){
            return null
        }
        return request.body?.toGetCharacterPageMapper()
    }
}