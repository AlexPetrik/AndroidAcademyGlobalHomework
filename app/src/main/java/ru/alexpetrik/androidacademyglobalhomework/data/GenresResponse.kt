package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenresResponse(
    @SerialName("genres")
    val genres: List<Genre>
)
