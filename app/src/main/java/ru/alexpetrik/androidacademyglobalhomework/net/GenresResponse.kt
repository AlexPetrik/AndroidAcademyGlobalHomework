package ru.alexpetrik.androidacademyglobalhomework.net

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.alexpetrik.androidacademyglobalhomework.data.Genre

@Serializable
data class GenresResponse(
    @SerialName("genres")
    val genres: List<Genre>
)
