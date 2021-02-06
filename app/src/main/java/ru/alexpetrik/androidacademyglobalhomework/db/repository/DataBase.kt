package ru.alexpetrik.androidacademyglobalhomework.db.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.alexpetrik.androidacademyglobalhomework.db.DbContract.DATA_BASE_NAME
import ru.alexpetrik.androidacademyglobalhomework.db.dao.ActorDao
import ru.alexpetrik.androidacademyglobalhomework.db.dao.GenreDao
import ru.alexpetrik.androidacademyglobalhomework.db.dao.MovieDao
import ru.alexpetrik.androidacademyglobalhomework.db.dao.MoviesGenreDao
import ru.alexpetrik.androidacademyglobalhomework.db.entity.*
import kotlin.reflect.KClass

@Database(entities = [GenreDb::class,
    ActorDb::class,
    MovieDb::class,
    MovieGenreJoin::class,
    MovieActorJoin::class], version = 1)
abstract class DataBase : RoomDatabase(){
    companion object {
        fun create(applicationContext: Context): DataBase = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java,
            DATA_BASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    abstract fun genreDao() : GenreDao
    abstract fun movieDao() : MovieDao
    abstract fun genresForMovie() : MoviesGenreDao
    abstract fun actorDao(): ActorDao
}