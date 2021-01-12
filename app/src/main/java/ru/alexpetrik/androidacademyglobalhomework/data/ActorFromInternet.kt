package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorFromInternet(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String?,
    @SerialName("profile_path")
    var profilePath: String?,
    @SerialName("known_for_department")
    val role: String? = null,
    @SerialName("order")
   val order: Int? = null
)