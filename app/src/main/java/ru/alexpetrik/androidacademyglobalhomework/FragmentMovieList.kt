package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import ru.alexpetrik.androidacademyglobalhomework.data.Movie
import ru.alexpetrik.androidacademyglobalhomework.data.loadMovies

class FragmentMovieList : Fragment() {

    private var listener: ClickListener? = null
    private var recycler: RecyclerView? = null

    private var scope = CoroutineScope(Dispatchers.Default)

    companion object {
        fun newInstance() = FragmentMovieList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.rv_movies)
        recycler?.adapter = MovieListAdapter(movieClickListener)
        recycler?.layoutManager = GridLayoutManager(requireContext(), 2)

        listener = activity as ClickListener
    }

    override fun onStart() {
        super.onStart()
        scope.launch {
            updateData()
        }
    }

    private suspend fun updateData() {
        (recycler?.adapter as? MovieListAdapter)?.apply {
            withContext(Dispatchers.Main) {
                bindMovies(loadMovies(requireContext()))
            }
        }
    }

    private fun doOnClick(movie: Movie) {
        listener?.changeFragment(this, movie)
    }

    private val movieClickListener = object : OnMovieClickListener {
        override fun onClick(movie: Movie) {
            doOnClick(movie)
        }

    }
}
