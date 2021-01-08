package ru.alexpetrik.androidacademyglobalhomework

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi
import ru.alexpetrik.androidacademyglobalhomework.data.Actor
import ru.alexpetrik.androidacademyglobalhomework.data.Movie
import ru.alexpetrik.androidacademyglobalhomework.data.loadActors
import ru.alexpetrik.androidacademyglobalhomework.data.loadMovies

@ExperimentalSerializationApi
class MovieDetailsViewModelFromInternet: ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Default)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("LoadMovies", "Coroutine exception, scope active:${scope.isActive}", throwable)
    }

    private val _mutableActorsList = MutableLiveData<List<Actor>>(emptyList())
    val actorsList: LiveData<List<Actor>> get() = _mutableActorsList

    fun loadActorsList(movieId : Int) {
        scope.launch(exceptionHandler) {
            withContext(Dispatchers.Main) {
                _mutableActorsList.value = loadActors(movieId)
            }
        }
    }

}