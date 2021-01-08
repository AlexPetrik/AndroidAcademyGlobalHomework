package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi
import ru.alexpetrik.androidacademyglobalhomework.apiKey
import ru.alexpetrik.androidacademyglobalhomework.globalGenres

val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

@ExperimentalSerializationApi
suspend fun loadGenres() {
    coroutineScope.launch {
        val genresCall = RetrofitModule.movieAPI
            .loadGenresAsync(apiKey)
            .await()
        globalGenres = genresCall.genres
    }
}

@ExperimentalSerializationApi
suspend fun loadMovies() : List<Movie> = withContext(Dispatchers.IO) {
    val moviesCall = RetrofitModule.movieAPI
        .loadPopularMoviesAsync(apiKey)
        .await()

    parseMoviesResponse(moviesCall.results)
}

@ExperimentalSerializationApi
suspend fun loadActors(movieId: Int) : List<Actor> = withContext(Dispatchers.IO) {
    val actorsCall = RetrofitModule.movieAPI
        .loadActorsAsync(movieId, apiKey)
        .await()

    actorsCall.cast.filter { it.role == "Acting" }.sortedBy { it.order }.subList(0, 10)
}

private fun parseMoviesResponse(_moviesList: List<MovieFromInternet>?): List<Movie> {
    val genresMap = globalGenres.associateBy { it.id }
    val movieList = mutableListOf<Movie>()
    _moviesList?.forEach { _element ->
        movieList.add(
            Movie(
                id = _element.id,
                title = _element.title,
                overview = _element.overview,
                poster = _element.poster,
                backdrop = _element.backdrop,
                ratings = _element.ratings / 2,
                numberOfRatings = _element.numberOfRatings,
                minimumAge = if (_element.adult) 16 else 13,
                runtime = _element.runtime,
                genres = _element.genre_ids?.map { it ->
                    genresMap[it] ?: throw IllegalArgumentException("Genre not found")
                },
                actors = null
            )
        )
    }
    return movieList
}

