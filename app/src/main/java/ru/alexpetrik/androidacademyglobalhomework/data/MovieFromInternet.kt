package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieFromInternet(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("poster_path")
    val poster: String?,
    @SerialName("backdrop_path")
    val backdrop: String?,
    @SerialName("vote_average")
    val ratings: Float,
    @SerialName("vote_count")
    val numberOfRatings: Int,
    @SerialName("adult")
    val adult: Boolean,
    val runtime: Int = 100,
    @SerialName("genre_ids")
    val genre_ids: List<Int>?
)