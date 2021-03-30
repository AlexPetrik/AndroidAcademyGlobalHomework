 package ru.alexpetrik.androidacademyglobalhomework

import android.app.Application
import androidx.work.*
import ru.alexpetrik.androidacademyglobalhomework.db.repository.DataBase
import ru.alexpetrik.androidacademyglobalhomework.worker.MovieLoadWorker
import java.util.concurrent.TimeUnit

class MovieListApp : Application() {

    override fun onCreate() {
        super.onCreate()
        database = DataBase.create(this)

        instance = this

        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()

        val worker = PeriodicWorkRequest.Builder(MovieLoadWorker::class.java, 8, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(WORK_NAME, ExistingPeriodicWorkPolicy.REPLACE, worker)
    }

    fun getDataBase() = database

    companion object {
        lateinit var instance: MovieListApp
        lateinit var database : DataBase

        const val WORK_NAME = "update movies"
    }
}