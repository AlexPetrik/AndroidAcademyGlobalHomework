package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val id: Int,
    val title: String?,
    val overview: String?,
    val poster_path: String?,
    val backdrop_path: String?,
    val vote_average: Float,
    val vote_count: Int,
    val adult: Boolean,
    val runtime: Int = 100,
    val genre_ids: List<Int>?
)