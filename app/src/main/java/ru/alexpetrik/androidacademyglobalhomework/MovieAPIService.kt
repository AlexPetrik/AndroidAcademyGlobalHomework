package ru.alexpetrik.androidacademyglobalhomework

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.alexpetrik.androidacademyglobalhomework.data.ActorsResponse
import ru.alexpetrik.androidacademyglobalhomework.data.GenresResponse
import ru.alexpetrik.androidacademyglobalhomework.data.MoviesResponse

interface MovieAPIService {

    @GET("movie/popular?")
    fun loadPopularMoviesAsync(
        @Query("api_key")
        apiKey: String,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page: String = "1"
    ) : Deferred<MoviesResponse>

    @GET("genre/movie/list?")
    fun loadGenresAsync(
        @Query("api_key")
        apiKey: String,
        @Query("language")
        language: String = "en-US"
    ) : Deferred<GenresResponse>

    @GET("movie/{movie_id}/credits?")
    fun loadActorsAsync(
        @Path("movie_id")
        movieId: Int,
        @Query("api_key")
        apiKey: String,
        @Query("language")
        language: String = "en-US"
    ) : Deferred<ActorsResponse>

}