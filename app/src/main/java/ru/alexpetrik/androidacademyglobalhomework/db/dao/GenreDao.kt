package ru.alexpetrik.androidacademyglobalhomework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.GENRE_TABLE_NAME
import ru.alexpetrik.androidacademyglobalhomework.db.entity.GenreDb

@Dao
interface GenreDao {

    @Query("SELECT * FROM $GENRE_TABLE_NAME")
    suspend fun getAll(): List<GenreDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genre: GenreDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(genres: List<GenreDb>)
}