package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentMovieDetails : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    companion object {
        //        fun newInstance(param1: String, param2: String) =
//            FragmentMovieList().apply {
//                arguments = Bundle().apply {
//                    putString("ARG_PARAM1", param1)
//                    putString("ARG_PARAM2", param2)
//                }
//            }
        fun newInstance() = FragmentMovieDetails()
    }

}