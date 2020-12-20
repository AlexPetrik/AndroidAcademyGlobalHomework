package ru.alexpetrik.androidacademyglobalhomework

import ru.alexpetrik.androidacademyglobalhomework.data.Genre

fun getTagFromGenres(genres: List<Genre>): CharSequence {
    var tag = ""
    for (genre in genres) {
        tag += "${genre.name}, "
    }
    return tag.removeSuffix(", ")
}