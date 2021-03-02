package ru.alexpetrik.androidacademyglobalhomework.net

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorsResponse(
    @SerialName("cast")
    val cast: List<ActorResponse>
)