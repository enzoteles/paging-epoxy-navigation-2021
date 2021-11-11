package com.example.koroutinesmvvm.domain.repo.detail

import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper

interface ShareRepository {
    suspend fun getCharacterById(characterId: Int): GetCharacterByIdMapper?
}