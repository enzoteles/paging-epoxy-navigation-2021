package com.example.koroutinesmvvm.domain.model

data class GetCharacterByIdMapper(
    val episode: List<String> = listOf(),
    val id: Int = 0,
    val image: String = "",
    val location: LocationMapper = LocationMapper(),
    val name: String = "",
    val origin: OriginMapper = OriginMapper(),
    val species: String = "",
    val status:String = "",
)

data class LocationMapper(
    val name: String = "",
    val url: String = ""
)

data class OriginMapper(
    val name: String = "",
    val url: String = ""
)