package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentMovieList : Fragment() {

    private var listener: ClickListener? = null
    private var movie: View? = null
    private var showedFragment: Fragment? = null

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

        movie = view.findViewById<View>(R.id.movie).apply {
            setOnClickListener {
                showedFragment?.let { it -> listener?.changeFragment(it) }
            }
        }
    }

    companion object {
        fun newInstance() = FragmentMovieList()
    }

    fun setListener(l: ClickListener, showedFragment: Fragment) {
        listener = l
        this.showedFragment = showedFragment
    }

}