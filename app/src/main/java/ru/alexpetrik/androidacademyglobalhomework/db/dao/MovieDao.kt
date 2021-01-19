package ru.alexpetrik.androidacademyglobalhomework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.alexpetrik.androidacademyglobalhomework.db.entity.MovieDb

import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract.MOVIE_TABLE_NAME
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract.MovieContract.COLUMN_NAME_ID as movieId
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract.MovieContract.COLUMN_NAME_RATINGS as rating

@Dao
interface MovieDao {

    @Query("SELECT * FROM $MOVIE_TABLE_NAME ORDER BY $rating")
    suspend fun getAll(): List<MovieDb>

    @Query("SELECT * FROM $MOVIE_TABLE_NAME WHERE $movieId = :id")
    suspend fun getAllById(id: Int): List<MovieDb>

    @Insert
    suspend fun insert(movie: MovieDb)

    @Query("DELETE FROM $MOVIE_TABLE_NAME WHERE $movieId = :id")
    suspend fun deleteById(id: Long)

}