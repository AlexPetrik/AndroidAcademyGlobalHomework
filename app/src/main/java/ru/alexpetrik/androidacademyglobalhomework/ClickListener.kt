package ru.alexpetrik.androidacademyglobalhomework

import androidx.fragment.app.Fragment
import ru.alexpetrik.androidacademyglobalhomework.data.Movie

interface ClickListener {
        fun changeFragment(showedFragment: Fragment, movie: Movie?)
}
