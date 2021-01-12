package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: Int,
    val name: String?,
    var profilePath: String?
) : java.io.Serializable