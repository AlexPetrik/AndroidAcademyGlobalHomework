package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorsResponse(
    @SerialName("cast")
    val cast: List<ActorResponse>
)