package com.example.koroutinesmvvm.data.remote

import com.example.koroutinesmvvm.domain.model.GetCharacterPageMapper
import com.example.koroutinesmvvm.domain.model.InfoMapper

data class GetCharacterPageDTO(
    val info: Info,
    val results: List<GetCharacterByIdDTO>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
)



fun GetCharacterPageDTO.toGetCharacterPageMapper(): GetCharacterPageMapper {
    return GetCharacterPageMapper(
       info = InfoMapper(count = info.count, next = info.next, pages = info.pages),
       results = results.map { it.toGetCharacterByIdMapper() }
    )
}