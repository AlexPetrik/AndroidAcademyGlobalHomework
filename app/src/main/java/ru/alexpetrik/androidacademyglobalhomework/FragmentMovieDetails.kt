package ru.alexpetrik.androidacademyglobalhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.serialization.ExperimentalSerializationApi
import ru.alexpetrik.androidacademyglobalhomework.data.Actor
import ru.alexpetrik.androidacademyglobalhomework.data.Movie

@ExperimentalSerializationApi
class FragmentMovieDetails(private var movie: Movie? = null) : Fragment() {
    private var listener: ClickListener? = null
    private var backTextView: TextView? = null
    private var recycler: RecyclerView? = null

    companion object {
        const val KEY_MOVIE_EX = "KEY_MOVIE_EX"
        fun newInstance(movie: Movie?) = FragmentMovieDetails(movie)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            movie = savedInstanceState.getSerializable(KEY_MOVIE_EX) as Movie?
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY_MOVIE_EX, movie)
    }
    private fun fillContent(view: View, movie: Movie?) {
        if (movie != null) {
            view.findViewById<TextView>(R.id.movie_detail_movie_name).text = movie.title
            view.findViewById<TextView>(R.id.movie_detail_movie_tag).text = movie.genres?.let {
                getTagFromGenres(
                    it
                )
            }
            view.findViewById<RatingBar>(R.id.movie_detail_ratingBar).rating = movie.ratings / 2
            view.findViewById<TextView>(R.id.movie_detail_reviews).text = "${movie.numberOfRatings} reviews"
            view.findViewById<TextView>(R.id.movie_detail_ratio).text = "${movie.minimumAge}+"
            view.findViewById<TextView>(R.id.movie_detail_storyline_description).text = movie.overview

            Glide.with(view.context)
                .load(baseURlBackdrop + movie.poster)
                .centerCrop()
                .into(view.findViewById(R.id.movie_detail_mask))

            val viewModel = MovieDetailsViewModelFromInternet()
            viewModel.loadActorsList(movieId = movie.id)
            viewModel.actorsList.observe(this.viewLifecycleOwner, this::updateActorsList)
        }
    }

    override fun onStart() {
        super.onStart()
        listener = activity as ClickListener
        backTextView?.setOnClickListener {
            listener?.changeFragment(this, null)
        }
    }

    private fun updateActorsList(actors: List<Actor>) {
        (recycler?.adapter as? ActorListAdapter)?.apply {
            bindActors(actors)
        }
    }
}
