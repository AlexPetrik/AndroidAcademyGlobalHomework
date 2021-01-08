package ru.alexpetrik.androidacademyglobalhomework.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
data class Genre(val id: Int, val name: String?)