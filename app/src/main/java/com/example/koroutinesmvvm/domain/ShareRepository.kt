package com.example.koroutinesmvvm.domain

import com.example.koroutinesmvvm.data.remote.GetCharacterByIdDTO

interface ShareRepository {
    suspend fun getCharacterById(characterId: Int): GetCharacterByIdDTO?
}