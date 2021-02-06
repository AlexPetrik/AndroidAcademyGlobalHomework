package ru.alexpetrik.androidacademyglobalhomework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.MovieContract

@Entity(tableName = DbContract.MOVIE_TABLE_NAME)
data class MovieDb(
    @PrimaryKey @ColumnInfo(name = MovieContract.COLUMN_NAME_ID) val id: Int,
    @ColumnInfo(name = MovieContract.COLUMN_NAME_TITLE) val title: String?,
    @ColumnInfo(name = MovieContract.COLUMN_NAME_OVERVIEW) val overview: String?,
    @ColumnInfo(name = MovieContract.COLUMN_NAME_POSTER) val poster: String?,
    @ColumnInfo(name = MovieContract.COLUMN_NAME_BACKDROP) val backdrop: String?,
    @ColumnInfo(name = MovieContract.COLUMN_NAME_RATINGS) val ratings: Float,
    @ColumnInfo(name = MovieContract.COLUMN_NAME_NUMBER_RATINGS) val numberOfRatings: Int,
    @ColumnInfo(name = MovieContract.COLUMN_NAME_AGE) val minimumAge: Int,
    @ColumnInfo(name = MovieContract.COLUMN_NAME_RUNTIME) val runtime: Int,
)
