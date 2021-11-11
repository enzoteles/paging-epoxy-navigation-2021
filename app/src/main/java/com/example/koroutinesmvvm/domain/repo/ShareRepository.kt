package com.example.koroutinesmvvm.domain.repo

import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper

interface ShareRepository {
    suspend fun getCharacterById(characterId: Int): GetCharacterByIdMapper?
}