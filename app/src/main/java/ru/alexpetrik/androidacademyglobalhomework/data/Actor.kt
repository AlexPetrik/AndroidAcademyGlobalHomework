package ru.alexpetrik.androidacademyglobalhomework.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: Int,
    val name: String?,
    val picture: String?
)