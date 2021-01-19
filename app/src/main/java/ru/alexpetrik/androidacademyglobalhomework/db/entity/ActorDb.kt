package ru.alexpetrik.androidacademyglobalhomework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexpetrik.androidacademyglobalhomework.db.MovieDbContract

@Entity(tableName = MovieDbContract.ACTOR_TABLE_NAME)
data class ActorDb(
    @PrimaryKey @ColumnInfo(name = MovieDbContract.ActorContract.COLUMN_NAME_ID) val id: Int,
    @ColumnInfo(name = MovieDbContract.ActorContract.COLUMN_NAME_NAME) val name: String?,
    @ColumnInfo(name = MovieDbContract.ActorContract.COLUMN_NAME_PROFILE) var profilePath: String?
)