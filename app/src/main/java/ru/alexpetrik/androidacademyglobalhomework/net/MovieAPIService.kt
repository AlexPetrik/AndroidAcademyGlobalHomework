package ru.alexpetrik.androidacademyglobalhomework.net

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.alexpetrik.androidacademyglobalhomework.net.ActorsResponse
import ru.alexpetrik.androidacademyglobalhomework.net.GenresResponse
import ru.alexpetrik.androidacademyglobalhomework.net.MoviesResponse

interface MovieAPIService {

    @GET("movie/popular?")
    fun loadPopularMoviesAsync(
        @Query("page")
        page: String = "1"
    ) : Deferred<MoviesResponse>

    @GET("genre/movie/list?")
    fun loadGenresAsync(
    ) : Deferred<GenresResponse>

    @GET("movie/{movie_id}/credits?")
    fun loadActorsAsync(
        @Path("movie_id")
        movieId: Int,
    ) : Deferred<ActorsResponse>

}