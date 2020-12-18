package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMovieDetails(private var movie: Movie? = null) : Fragment() {
    private var listener: ClickListener? = null
    private var backTextView: TextView? = null
    private var recycler: RecyclerView? = null

    companion object {
        fun newInstance(movie: Movie?) = FragmentMovieDetails(movie)
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
        backTextView?.setOnClickListener {
            listener?.changeFragment(this, null)
        }

        recycler = view.findViewById(R.id.actor_list_rv)
        recycler?.adapter = ActorListAdapter()
        recycler?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        fillContent(view, movie)
   }

    private fun fillContent(view: View, movie: Movie?) {
        if (movie != null) {
            view.findViewById<TextView>(R.id.movie_detail_movie_name).text = movie.movieName
            view.findViewById<TextView>(R.id.movie_detail_movie_tag).text = movie.tag
            view.findViewById<ImageView>(R.id.movie_detail_mask).setImageResource(movie.image)
            view.findViewById<RatingBar>(R.id.movie_detail_ratingBar).numStars = movie.rating
            view.findViewById<TextView>(R.id.movie_detail_reviews).text = "${movie.reviews} reviews"
            view.findViewById<TextView>(R.id.movie_detail_ratio).text = "${movie.ratio}+"
            view.findViewById<TextView>(R.id.movie_detail_storyline_description).text = getText(movie.storyLine)

            (recycler?.adapter as? ActorListAdapter)?.apply {
                bindMovies(movie.actors)
            }

        }
    }

    override fun onStart() {
        super.onStart()
        listener = activity as ClickListener
        backTextView?.setOnClickListener {
            listener?.changeFragment(this, null)
        }
    }
}
