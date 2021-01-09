package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.serialization.Serializable

@Serializable
data class Genre(val id: Int, val name: String?) : java.io.Serializable