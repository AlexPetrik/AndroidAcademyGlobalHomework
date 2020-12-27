package ru.alexpetrik.androidacademyglobalhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.alexpetrik.androidacademyglobalhomework.data.Genre
import ru.alexpetrik.androidacademyglobalhomework.data.Movie

class MovieListAdapter(private val clickListener: OnMovieClickListener): RecyclerView.Adapter<MovieListViewHolder>() {

    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder =
        MovieListViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false))

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(movies[position])
        holder.itemView.setOnClickListener {
            clickListener.onClick(movies[position])
        }
    }

    override fun getItemCount() = movies.size

    fun bindMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }
}

class MovieListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val movieNameTextView: TextView = itemView.findViewById(R.id.activity_main_movie_name)
    private val movieImgImageView: ImageView = itemView.findViewById(R.id.activity_main_movie_img)
    private val movieTagTextView: TextView = itemView.findViewById(R.id.activity_main_tag)
    private val movieDurationTextView: TextView = itemView.findViewById(R.id.activity_main_duration)
    private val movieRatioTextView: TextView = itemView.findViewById(R.id.activity_main_ratio)
    private val movieRatingRatingBar: RatingBar = itemView.findViewById(R.id.activity_main_ratingBar)
    private val movieReviewTextView: TextView = itemView.findViewById(R.id.activity_main_review)

    fun onBind(movie: Movie) {
        Glide.with(itemView.context)
            .load(movie.poster)
            .into(movieImgImageView)
        movieNameTextView.text = movie.title
        movieTagTextView.text = movie.genres?.let { getTagFromGenres(it) }
        movieDurationTextView.text = "${movie.runtime} min"
        movieRatioTextView.text = "${movie.minimumAge}+"
        movieRatingRatingBar.rating = movie.ratings / 2
        movieReviewTextView.text = "${movie.numberOfRatings} reviews"
    }

}

interface OnMovieClickListener {
    fun onClick(movie: Movie)
}