package com.example.koroutinesmvvm.domain.repo

import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper
import com.example.koroutinesmvvm.domain.model.GetCharacterPageMapper

interface CharacterRepository {
     suspend fun getCharacterList(pageIndex: Int): GetCharacterPageMapper?
}