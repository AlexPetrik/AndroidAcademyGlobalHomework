package ru.alexpetrik.androidacademyglobalhomework

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.alexpetrik.androidacademyglobalhomework.data.Actor
import ru.alexpetrik.androidacademyglobalhomework.data.loadActors
import ru.alexpetrik.androidacademyglobalhomework.db.repository.readActorsFromDb
import ru.alexpetrik.androidacademyglobalhomework.db.repository.saveMovieActors

class MovieDetailsViewModelFromInternet: ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Default)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("LoadMovies", "Coroutine exception, scope active:${scope.isActive}", throwable)
    }

    private val _mutableActorsList = MutableLiveData<List<Actor>>(emptyList())
    val actorsList: LiveData<List<Actor>> get() = _mutableActorsList

    fun loadActorsList(movieId : Int) {
        scope.launch(exceptionHandler) {

            val localActors = withContext(Dispatchers.IO) {
                readActorsFromDb(movieId)
            }

            if (localActors.isNotEmpty())
                withContext(Dispatchers.Main) {
                    _mutableActorsList.value = localActors
                }

            val remoteActors = withContext(Dispatchers.IO) {
                loadActors(movieId)
            }

            saveMovieActors(mapOf(movieId to remoteActors))
            withContext(Dispatchers.Main) {
                _mutableActorsList.value = remoteActors
            }
        }
    }

}