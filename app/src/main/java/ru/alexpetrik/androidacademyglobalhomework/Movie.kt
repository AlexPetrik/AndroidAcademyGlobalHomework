package ru.alexpetrik.androidacademyglobalhomework

data class Movie(
    val movieName: String,
    val image: Int,
    val tag: String,
    val duration: Int,
    val ratio: Int,
    val rating: Int,
    val reviews: Int,
    val storyLine: Int = R.string.no_description,
    val actors: List<Actor> = listOf()
)
