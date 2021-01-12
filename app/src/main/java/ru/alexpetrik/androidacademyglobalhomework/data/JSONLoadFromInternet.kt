package ru.alexpetrik.androidacademyglobalhomework.data

import kotlinx.coroutines.*
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

    parseActorsResponse(actorsCall.cast)
}

private fun parseActorsResponse(_actorsList: List<ActorFromInternet>?): List<Actor> {
    val actorsList = mutableListOf<Actor>()
    _actorsList?.filter { it.role == "Acting" }
        ?.sortedBy { it.order }
        ?.subList(0, 10)
        ?.forEach {
            actorsList.add(
                Actor(
                    id = it.id,
                    name = it.name,
                    profilePath = baseURlPoster + it.profilePath
                )
            )
        }
    return actorsList
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

