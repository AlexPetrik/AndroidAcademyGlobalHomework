package ru.alexpetrik.androidacademyglobalhomework

import ru.alexpetrik.androidacademyglobalhomework.data.Genre

fun getTagFromGenres(genres: List<Genre>): CharSequence {
    var tag = ""
    for (genre in genres) {
        tag += "${genre.name}, "
    }
    return tag.removeSuffix(", ")
}

const val apiKey = "5412c159d140ab846e8ea9110c92632b"
const val baseURL = "https://api.themoviedb.org/3/"
const val baseURlBackdrop = "http://image.tmdb.org/t/p/w300"
const val baseURlPoster = "http://image.tmdb.org/t/p/w185"

var globalGenres: List<Genre> = emptyList()