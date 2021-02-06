package ru.alexpetrik.androidacademyglobalhomework

import android.app.Application
import ru.alexpetrik.androidacademyglobalhomework.db.repository.DataBase

class MovieListApp : Application() {

    override fun onCreate() {
        super.onCreate()
        database = DataBase.create(this)

        instance = this
    }

    companion object {
        lateinit var instance: MovieListApp
        lateinit var database : DataBase
    }
}