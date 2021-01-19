package ru.alexpetrik.androidacademyglobalhomework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract

import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract.MovieActorJoinContract.COLUMN_NAME_MOVIE_ID as movieActorJoinContractMovieId
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract.MovieActorJoinContract.COLUMN_NAME_ACTOR_ID as movieActorJoinContractActorId

@Entity(
    tableName = MovieDbContract.MOVIE_ACTOR_TABLE_NAME,
    primaryKeys = [movieActorJoinContractMovieId, movieActorJoinContractActorId],
    indices = [
        Index(value = [movieActorJoinContractMovieId]),
        Index(value = [movieActorJoinContractActorId])
    ],
    foreignKeys = [
        ForeignKey(entity = MovieDb::class,
            parentColumns = [MovieDbContract.MovieContract.COLUMN_NAME_ID],
            childColumns = [movieActorJoinContractMovieId],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = ActorDb::class,
            parentColumns = [MovieDbContract.ActorContract.COLUMN_NAME_ID],
            childColumns = [movieActorJoinContractActorId],
            onDelete = ForeignKey.CASCADE
        )
    ],
)
data class MovieActorJoin(
    @ColumnInfo(name = movieActorJoinContractMovieId) val movieId: String,
    @ColumnInfo(name = movieActorJoinContractActorId) val actorId: String
)
