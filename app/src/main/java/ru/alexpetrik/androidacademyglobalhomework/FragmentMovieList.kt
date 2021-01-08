package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi
import ru.alexpetrik.androidacademyglobalhomework.data.Movie
import ru.alexpetrik.androidacademyglobalhomework.data.loadMovies

@ExperimentalSerializationApi
class FragmentMovieList : Fragment() {

    private var listener: ClickListener? = null
    private var recycler: RecyclerView? = null

    private lateinit var viewModelFromInternet: MovieListViewModelFromInternet

    companion object {
        fun newInstance() = FragmentMovieList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            viewModelFromInternet = MovieListViewModelFromInternet()

            recycler = view.findViewById(R.id.rv_movies)
            recycler?.adapter = MovieListAdapter(movieClickListener)
            recycler?.layoutManager = GridLayoutManager(it, 2)

            listener = activity as ClickListener
        }
    }

    override fun onStart() {
        super.onStart()
        viewModelFromInternet.loadMovieList()
        viewModelFromInternet.movieList.observe(this.viewLifecycleOwner, this::updateAdapter)
    }

    override fun onDestroy() {
        recycler?.adapter = null
        recycler = null

        super.onDestroy()
    }

    private fun updateAdapter(movies: List<Movie>) {
        (recycler?.adapter as? MovieListAdapter)?.apply {
            bindMovies(movies)
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
