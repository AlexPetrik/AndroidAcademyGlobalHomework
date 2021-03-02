package ru.alexpetrik.androidacademyglobalhomework.net

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("results")
    val results: List<MovieResponse>
)
