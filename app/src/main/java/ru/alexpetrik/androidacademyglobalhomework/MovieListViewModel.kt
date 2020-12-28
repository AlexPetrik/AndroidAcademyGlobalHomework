package ru.alexpetrik.androidacademyglobalhomework

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.alexpetrik.androidacademyglobalhomework.data.Movie
import ru.alexpetrik.androidacademyglobalhomework.data.loadMovies

class MovieListViewModel(private val context: Context): ViewModel() {

    private var scope = CoroutineScope(Dispatchers.Default)

    private val _mutableMovieList = MutableLiveData<List<Movie>>(emptyList())
    val movieList: LiveData<List<Movie>> get() = _mutableMovieList

    fun loadMovieList() {
        scope.launch {
            updateData()

        }
    }

    private suspend fun updateData() {
        withContext(Dispatchers.Main) {
            _mutableMovieList.setValue(loadMovies(context))
        }
    }
}
