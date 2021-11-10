package com.example.koroutinesmvvm.data.remote

import com.example.koroutinesmvvm.domain.model.GetCharacterById

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

fun GetCharacterByIdDTO.toCoinDetail(): GetCharacterById {
    return GetCharacterById(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        location = com.example.koroutinesmvvm.domain.model.Location(location.name, location.url),
        name = name,
        origin = com.example.koroutinesmvvm.domain.model.Origin(origin.name, origin.url)
    )
}