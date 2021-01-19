package ru.alexpetrik.androidacademyglobalhomework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract.MovieGenreJoinContract.COLUMN_NAME_MOVIE_ID as movieGenreJoinContractMovieId
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract.MovieGenreJoinContract.COLUMN_NAME_GENRE_ID as movieGenreJoinContractGenreId

@Entity(
    tableName = MovieDbContract.MOVIE_GENRE_TABLE_NAME,
    primaryKeys = [movieGenreJoinContractMovieId, movieGenreJoinContractGenreId],
    indices = [
        Index(value = [movieGenreJoinContractMovieId]),
        Index(value = [movieGenreJoinContractGenreId])
    ],
    foreignKeys = [
        ForeignKey(entity = MovieDb::class,
            parentColumns = [MovieDbContract.MovieContract.COLUMN_NAME_ID],
            childColumns = [movieGenreJoinContractMovieId],
            onDelete = CASCADE),
        ForeignKey(entity = GenreDb::class,
            parentColumns = [MovieDbContract.GenreContract.COLUMN_NAME_ID],
            childColumns = [movieGenreJoinContractGenreId],
            onDelete = CASCADE)
    ],
)
data class MovieGenreJoin(
    @ColumnInfo(name = movieGenreJoinContractMovieId) val movieId: String,
    @ColumnInfo(name = movieGenreJoinContractGenreId) val genreId: String
)
