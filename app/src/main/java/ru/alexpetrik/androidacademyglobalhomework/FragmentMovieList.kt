package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.alexpetrik.androidacademyglobalhomework.data.Movie

class FragmentMovieList : Fragment() {

    private var listener: ClickListener? = null
    private var recycler: RecyclerView? = null
    private var currentVisiblePosition = 0

    private lateinit var viewModelFromInternet: MovieListViewModelFromInternet

    companion object {
        fun newInstance() = FragmentMovieList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
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

    override fun onPause() {
        super.onPause()
        currentVisiblePosition = (recycler?.layoutManager as GridLayoutManager).findFirstVisibleItemPosition()
    }

    override fun onResume() {
        super.onResume()
        (recycler?.layoutManager as GridLayoutManager).scrollToPositionWithOffset(currentVisiblePosition, 0)
    }

    override fun onDestroy() {
        recycler?.adapter = null
        recycler = null
        currentVisiblePosition = 0

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
