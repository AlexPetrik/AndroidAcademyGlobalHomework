package ru.alexpetrik.androidacademyglobalhomework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract

import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.MovieActorJoinContract.COLUMN_NAME_MOVIE_ID as movieActorJoinContractMovieId
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.MovieActorJoinContract.COLUMN_NAME_ACTOR_ID as movieActorJoinContractActorId

@Entity(
    tableName = DbContract.MOVIE_ACTOR_TABLE_NAME,
    primaryKeys = [movieActorJoinContractMovieId, movieActorJoinContractActorId],
    indices = [
        Index(value = [movieActorJoinContractMovieId]),
        Index(value = [movieActorJoinContractActorId])
    ],
    foreignKeys = [
        ForeignKey(entity = MovieDb::class,
            parentColumns = [DbContract.MovieContract.COLUMN_NAME_ID],
            childColumns = [movieActorJoinContractMovieId],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = ActorDb::class,
            parentColumns = [DbContract.ActorContract.COLUMN_NAME_ID],
            childColumns = [movieActorJoinContractActorId],
            onDelete = ForeignKey.CASCADE
        )
    ],
)
data class MovieActorJoin(
    @ColumnInfo(name = movieActorJoinContractMovieId) val movieId: Int,
    @ColumnInfo(name = movieActorJoinContractActorId) val actorId: Int,
    @ColumnInfo(name = DbContract.ActorContract.COLUMN_NAME_NAME) val name: String?,
    @ColumnInfo(name = DbContract.ActorContract.COLUMN_NAME_PROFILE) var profilePath: String?
)
