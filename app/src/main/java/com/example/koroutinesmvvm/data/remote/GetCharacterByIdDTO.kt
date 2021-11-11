package com.example.koroutinesmvvm.data.remote

import com.example.koroutinesmvvm.domain.model.GetCharacterByIdMapper
import com.example.koroutinesmvvm.domain.model.LocationMapper
import com.example.koroutinesmvvm.domain.model.OriginMapper

data class GetCharacterByIdDTO(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class Location(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)

fun GetCharacterByIdDTO.toGetCharacterByIdMapper(): GetCharacterByIdMapper {
    return GetCharacterByIdMapper(
        episode = episode,
        id = id,
        image = image,
        location = LocationMapper(location.name, location.url),
        name = name,
        origin = OriginMapper(origin.name, origin.url),
        species = species,
        status = status
    )
}