package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentMovieDetails : Fragment() {
    private var listener: ClickListener? = null
    private var backTextView: TextView? = null

    companion object {
        fun newInstance() = FragmentMovieDetails()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backTextView = view.findViewById<TextView>(R.id.movie_detail_back_tv)
    }

    override fun onStart() {
        super.onStart()
        listener = activity as ClickListener
        backTextView?.setOnClickListener {
            listener?.changeFragment(this)
        }
    }
}
