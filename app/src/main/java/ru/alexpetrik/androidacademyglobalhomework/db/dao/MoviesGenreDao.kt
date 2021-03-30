package ru.alexpetrik.androidacademyglobalhomework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.MOVIE_GENRE_TABLE_NAME
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.MovieGenreJoinContract.COLUMN_NAME_MOVIE_ID
import ru.alexpetrik.androidacademyglobalhomework.db.entity.MovieGenreJoin

@Dao
interface MoviesGenreDao {

    @Query("SELECT * FROM $MOVIE_GENRE_TABLE_NAME WHERE $COLUMN_NAME_MOVIE_ID = :movieId")
    fun getGenresForMovie(movieId: Int) : List<MovieGenreJoin>

    suspend fun getGenresForMovieUntilChanged(id: Int) = getGenresForMovie(id).asFlow().distinctUntilChanged()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieGenreJoin: MovieGenreJoin)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listMovieGenreJoin: List<MovieGenreJoin>)

}