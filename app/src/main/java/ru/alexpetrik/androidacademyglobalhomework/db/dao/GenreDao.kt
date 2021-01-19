package ru.alexpetrik.androidacademyglobalhomework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract.GENRE_TABLE_NAME
import ru.alexpetrik.androidacademyglobalhomework.db.entity.GenreDb

@Dao
interface GenreDao {

    @Query("SELECT * FROM $GENRE_TABLE_NAME")
    suspend fun getAll(): List<GenreDb>

    @Insert
    suspend fun insert(genre: GenreDb)
}