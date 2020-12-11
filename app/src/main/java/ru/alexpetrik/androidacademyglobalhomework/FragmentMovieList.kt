package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMovieList : Fragment() {

    private var listener: ClickListener? = null
//    private var movie: View? = null
    private var recycler: RecyclerView? = null

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
        recycler?.adapter = MovieListAdapter()
        recycler?.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun onStart() {
        super.onStart()

        updateData()
//        listener = activity as ClickListener
//        movie?.setOnClickListener {
//            listener?.changeFragment(this)
//        }
    }

    private fun updateData() {
        (recycler?.adapter as? MovieListAdapter)?.apply {
            bindMovies(MoviesDataSource().getMovies())
        }
    }
}
