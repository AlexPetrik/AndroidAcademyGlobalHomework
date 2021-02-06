package ru.alexpetrik.androidacademyglobalhomework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.alexpetrik.androidacademyglobalhomework.db.entity.ActorDb
import ru.alexpetrik.androidacademyglobalhomework.db.entity.MovieActorJoin
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.MOVIE_ACTOR_TABLE_NAME as actorTableName
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.MovieActorJoinContract.COLUMN_NAME_MOVIE_ID as columnMovieId
import ru.alexpetrik.androidacademyglobalhomework.db.entity.MovieGenreJoin

@Dao
interface ActorDao {

    @Query("SELECT * FROM $actorTableName WHERE $columnMovieId = :movieId")
    fun getActorsForMovie(movieId: Int) : List<MovieActorJoin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(actorDb: MovieActorJoin)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listActors: List<MovieActorJoin>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActorsDb(listActors: List<ActorDb>)

}