package ru.alexpetrik.androidacademyglobalhomework

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.alexpetrik.androidacademyglobalhomework.data.Movie
import ru.alexpetrik.androidacademyglobalhomework.data.loadGenres
import ru.alexpetrik.androidacademyglobalhomework.data.loadMovies

class MovieListViewModelFromInternet : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Default)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("LoadMovies", "Coroutine exception, scope active:${scope.isActive}", throwable)
    }

    private val _mutableMovieList = MutableLiveData<List<Movie>>(emptyList())
    val movieList: LiveData<List<Movie>> get() = _mutableMovieList

    fun loadMovieList() {
        scope.launch(exceptionHandler) {
            loadGenres()
            withContext(Dispatchers.Main) {
                _mutableMovieList.value = loadMovies()
            }
        }
    }

}
