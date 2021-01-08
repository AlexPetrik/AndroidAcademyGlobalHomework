package ru.alexpetrik.androidacademyglobalhomework.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActorFromInternet(
    val id: Int,
    val name: String?,
    val picture: String?
) : Parcelable