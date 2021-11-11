package com.example.koroutinesmvvm.domain.model

data class GetCharacterPageMapper(
    val info: InfoMapper = InfoMapper(),
    val results: List<GetCharacterByIdMapper> = listOf()
)

data class InfoMapper(
    val count: Int = 0,
    val next: String = "",
    val pages: Int = 0,
    val prev: Int = 0
)



