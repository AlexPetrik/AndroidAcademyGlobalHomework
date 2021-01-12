package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi
import ru.alexpetrik.androidacademyglobalhomework.apiKey
import ru.alexpetrik.androidacademyglobalhomework.baseURlPoster
import ru.alexpetrik.androidacademyglobalhomework.globalGenres

val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

suspend fun loadGenres() {
    coroutineScope.launch {
        val genresCall = RetrofitModule.movieAPI
            .loadGenresAsync(apiKey)
            .await()
        globalGenres = genresCall.genres
    }
}

suspend fun loadMovies() : List<Movie> = withContext(Dispatchers.IO) {
    val moviesCall = RetrofitModule.movieAPI
        .loadPopularMoviesAsync(apiKey)
        .await()

    parseMoviesResponse(moviesCall.results)
}

suspend fun loadActors(movieId: Int) : List<Actor> = withContext(Dispatchers.IO) {
    val actorsCall = RetrofitModule.movieAPI
        .loadActorsAsync(movieId, apiKey)
        .await()

    val respondedActorsList = actorsCall.cast
    respondedActorsList.forEach {
        it.profile_path = baseURlPoster + it.profile_path
    }
    respondedActorsList.filter { it.known_for_department == "Acting" }.sortedBy { it.order }.subList(0, 10)
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
                poster = baseURlPoster + _element.poster_path,
                backdrop = _element.backdrop_path,
                ratings = _element.vote_average / 2,
                numberOfRatings = _element.vote_count,
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

