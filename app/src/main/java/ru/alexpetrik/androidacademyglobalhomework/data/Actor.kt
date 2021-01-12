package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: Int,
    val name: String?,
    var profile_path: String?,
    val known_for_department: String? = null,
    val order: Int? = null
) : java.io.Serializable