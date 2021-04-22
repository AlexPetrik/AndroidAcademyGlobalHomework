package ru.alexpetrik.androidacademyglobalhomework.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import ru.alexpetrik.androidacademyglobalhomework.MovieListApp
import ru.alexpetrik.androidacademyglobalhomework.data.Movie
import ru.alexpetrik.androidacademyglobalhomework.data.loadGenres
import ru.alexpetrik.androidacademyglobalhomework.data.loadMovies
import ru.alexpetrik.androidacademyglobalhomework.db.repository.database
import ru.alexpetrik.androidacademyglobalhomework.db.repository.saveRemoteFilmsToDb
import ru.alexpetrik.androidacademyglobalhomework.db.repository.saveRemoteGenres

class MovieLoadWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val remoteFilmsResult = loadMovies()
        val genres = loadGenres()

        saveRemoteGenres(genres)
        saveRemoteFilmsToDb(remoteFilmsResult)

        val moviesDao = database.movieDao()
        val moviesFromDb = moviesDao.getAll()

        return Result.success()
    }
}