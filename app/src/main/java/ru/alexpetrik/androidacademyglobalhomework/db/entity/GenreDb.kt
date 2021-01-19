package ru.alexpetrik.androidacademyglobalhomework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract

@Entity(tableName = MovieDbContract.GENRE_TABLE_NAME)
data class GenreDb(
    @PrimaryKey @ColumnInfo(name = MovieDbContract.GenreContract.COLUMN_NAME_ID) val id: Int,
    @ColumnInfo(name = MovieDbContract.GenreContract.COLUMN_NAME_NAME) val name: String
)
