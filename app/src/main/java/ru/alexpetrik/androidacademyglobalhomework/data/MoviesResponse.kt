package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("results")
    val results: List<MovieFromInternet>
)
