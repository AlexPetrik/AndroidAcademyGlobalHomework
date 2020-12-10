package ru.alexpetrik.androidacademyglobalhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), ClickListener {

    private val movieListFragment = FragmentMovieList.newInstance()
    private val movieDetailFragment = FragmentMovieDetails.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.fragments_container, movieListFragment)
                    commit()
                }
        }
    }

    override fun changeFragment(showedFragment: Fragment) {
        val nextFragment = when(showedFragment) {
            is FragmentMovieDetails -> movieListFragment
            is FragmentMovieList -> movieDetailFragment
            else -> null
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragments_container, nextFragment!!)
            addToBackStack(null)
            commit()
        }
    }
}