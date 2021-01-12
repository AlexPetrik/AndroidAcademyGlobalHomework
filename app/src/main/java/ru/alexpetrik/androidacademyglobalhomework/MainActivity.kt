package ru.alexpetrik.androidacademyglobalhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.alexpetrik.androidacademyglobalhomework.data.Movie

class MainActivity : AppCompatActivity(), ClickListener {

    private val movieListFragment = FragmentMovieList.newInstance()

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

    override fun changeFragment(showedFragment: Fragment, movie: Movie?) {
        val nextFragment = when(showedFragment) {
            is FragmentMovieDetails -> movieListFragment
            is FragmentMovieList -> FragmentMovieDetails.newInstance(movie)
            else -> null
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragments_container, nextFragment!!)
            addToBackStack(null)
            commit()
        }
    }
}