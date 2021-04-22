package ru.alexpetrik.androidacademyglobalhomework

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.alexpetrik.androidacademyglobalhomework.data.*
import ru.alexpetrik.androidacademyglobalhomework.db.repository.readFilmsFromDb
import ru.alexpetrik.androidacademyglobalhomework.db.repository.saveRemoteFilmsToDb
import ru.alexpetrik.androidacademyglobalhomework.db.repository.saveRemoteGenres

class MovieListViewModelFromInternet : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Default)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("LoadMovies", "Coroutine exception, scope active:${scope.isActive}", throwable)
    }

    private val _mutableMovieList = MutableLiveData<List<Movie>>(emptyList())
    val movieList: LiveData<List<Movie>> get() = _mutableMovieList

    fun loadMovieList() {
        scope.launch(exceptionHandler) {

            val localFilms = withContext(Dispatchers.IO) {
                readFilmsFromDb()
            }

            if (localFilms.isNotEmpty()) {
                withContext(Dispatchers.Main) { _mutableMovieList.value = localFilms }
            }

           val remoteFilmsResult = withContext(Dispatchers.IO) {
                globalGenres = loadGenres()
                loadMovies()
            }

            saveRemoteGenres(globalGenres)
            saveRemoteFilmsToDb(remoteFilmsResult)
            withContext(Dispatchers.Main) {
                _mutableMovieList.value = remoteFilmsResult
            }

        }
    }
}
