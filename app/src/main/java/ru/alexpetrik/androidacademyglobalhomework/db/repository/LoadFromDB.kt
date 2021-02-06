package ru.alexpetrik.androidacademyglobalhomework.db.repository

import ru.alexpetrik.androidacademyglobalhomework.MovieListApp
import ru.alexpetrik.androidacademyglobalhomework.data.Actor
import ru.alexpetrik.androidacademyglobalhomework.data.Genre
import ru.alexpetrik.androidacademyglobalhomework.data.Movie
import ru.alexpetrik.androidacademyglobalhomework.db.entity.*
import ru.alexpetrik.androidacademyglobalhomework.globalGenres

val database = MovieListApp.database

suspend fun readGenresFromDb() {
//    coroutineScope.launch {
        val genreDao = database.genreDao()
        val listGenreDb = genreDao.getAll()

        globalGenres = parseGenreDao(listGenreDb)
//    }
}

suspend fun readFilmsFromDb() : List<Movie> {
    readGenresFromDb()
    return readMoviesFromDb()
}

suspend fun readMoviesFromDb() : List<Movie> {

    val movieDao = database.movieDao()
    val listMovieDb = movieDao.getAll()


    return parseMovieDao(listMovieDb)
}

fun parseMovieDao(listMovieDb: List<MovieDb>): List<Movie> {
    val listMovie = mutableListOf<Movie>()

    listMovieDb.forEach {
        listMovie.add(
            Movie(
                id = it.id,
                title = it.title,
                overview = it.overview,
                poster = it.poster,
                backdrop = it.backdrop,
                ratings = it.ratings,
                numberOfRatings = it.numberOfRatings,
                minimumAge = it.minimumAge,
                runtime = it.runtime,
                genres = readGenresForMovie(it.id),
                actors = null
            )
        )
    }

    return listMovie
}

fun readGenresForMovie(id: Int): List<Genre> {
    val dao = database.genresForMovie()
    val listGenresDb = dao.getGenresForMovie(id)

    val listGenres = mutableListOf<Genre>()
    listGenresDb.forEach {
        listGenres.add(
            Genre(
                id = it.genreId,
                name = it.genreName
            )
        )
    }

    return listGenres
}

fun parseGenreDao(listGenreDb: List<GenreDb>) : List<Genre> {
    val listGenre = mutableListOf<Genre>()
    listGenreDb.forEach {
        listGenre.add(
            Genre(
                id = it.id,
                name = it.name
            )
        )
    }
    return listGenre
}

suspend fun saveRemoteFilmsToDb(listMovies: List<Movie>) {

    val movieDao = database.movieDao()

    val listMovieDb = mutableListOf<MovieDb>()

    listMovies.forEach {
        listMovieDb.add(
            MovieDb(
                id = it.id,
                title = it.title,
                overview = it.overview,
                poster = it.poster,
                backdrop = it.backdrop,
                ratings = it.ratings,
                numberOfRatings = it.numberOfRatings,
                minimumAge = it.minimumAge,
                runtime = it.runtime
            )
        )
//        movieDao.insert(movieDb)
    }

    movieDao.insertAll(listMovieDb)

    val genresOfMovie = listMovies.map{it.id to it.genres}.toMap()
    saveMovieGenresJoin(genresOfMovie)

}

fun saveMovieGenresJoin(genresOfMovie: Map<Int, List<Genre>?>) {

    val movieGenreJoins = mutableListOf<MovieGenreJoin>()

    genresOfMovie.forEach { (movieId, listGenres) ->
        listGenres?.forEach {
            movieGenreJoins.add(
                MovieGenreJoin(
                    movieId = movieId,
                    genreId = it.id,
                    genreName = it.name
                )
            )
        }
    }

    val movieGenreJoinDao = database.genresForMovie()
    movieGenreJoinDao.insertAll(movieGenreJoins)

}

suspend fun saveRemoteGenres(loadGenres: List<Genre>) {

    val listGenresDb = mutableListOf<GenreDb>()

    loadGenres.forEach {
        listGenresDb.add(
            GenreDb(
                id = it.id,
                name = it.name
            )
        )
    }

    val genreDao = database.genreDao()
    genreDao.insertAll(listGenresDb)

}

fun readActorsFromDb(id: Int) : List<Actor> {

    val actorDao = database.actorDao()
    val listActorDb = actorDao.getActorsForMovie(id)

    val listActors = mutableListOf<Actor>()
    listActorDb.forEach {
        listActors.add(
            Actor(
                id = it.actorId,
                name = it.name,
                profilePath = it.profilePath
            )
        )
    }

    return listActors
}

fun saveMovieActors(actorsOfMovie: Map<Int, List<Actor>?>) {

    val movieActorsJoins = mutableListOf<MovieActorJoin>()
    val actorsDb = mutableListOf<ActorDb>()

    actorsOfMovie.forEach { (movieId, listActors) ->
        listActors?.forEach {
            movieActorsJoins.add(
                MovieActorJoin(
                    movieId = movieId,
                    actorId = it.id,
                    name = it.name,
                    profilePath = it.profilePath
                )
            )

            actorsDb.add(
                ActorDb(
                    id = it.id,
                    name = it.name,
                    profilePath = it.profilePath
                )
            )
        }
    }

    val actorDao = database.actorDao()
    actorDao.insertAllActorsDb(actorsDb)
    actorDao.insertAll(movieActorsJoins)

}
