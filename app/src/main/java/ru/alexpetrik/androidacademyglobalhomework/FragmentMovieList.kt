package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentMovieList : Fragment() {

    private var listener: ClickListener? = null
    private var movie: View? = null

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
        movie = view.findViewById(R.id.movie)
    }

    override fun onStart() {
        super.onStart()
        listener = activity as ClickListener
        movie?.setOnClickListener {
            listener?.changeFragment(this)
        }
    }
}
