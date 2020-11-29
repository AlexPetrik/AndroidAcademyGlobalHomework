package ru.alexpetrik.androidacademyglobalhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.RatingBar
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), ClickListener {

    private val movieListFragment = FragmentMovieList.newInstance()

    private val movieDetailFragment = FragmentMovieDetails.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.fragments_container, movieListFragment)
                commit()
            }

        movieListFragment.setListener(this@MainActivity, movieDetailFragment)
        movieDetailFragment.setListener(this@MainActivity, movieListFragment)
    }

    override fun changeFragment(showedFragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragments_container, showedFragment)
            commit()
        }
    }
}