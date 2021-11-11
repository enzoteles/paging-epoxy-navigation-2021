package com.example.koroutinesmvvm.domain.model

data class GetCharacterByIdMapper(
    val episode: List<String> = listOf(),
    val id: Int = 0,
    val image: String = "",
    val location: Location = Location(),
    val name: String = "",
    val origin: Origin = Origin(),
    val species: String = "",
    val status:String = "",
)

data class Location(
    val name: String = "",
    val url: String = ""
)

data class Origin(
    val name: String = "",
    val url: String = ""
)