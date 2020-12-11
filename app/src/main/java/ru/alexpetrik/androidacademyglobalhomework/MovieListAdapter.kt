package ru.alexpetrik.androidacademyglobalhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter: RecyclerView.Adapter<MovieListViewHolder>() {

    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder =
        MovieListViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false))

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(movies[position])
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
        movieNameTextView.text = movie.movieName
        movieImgImageView.setImageResource(movie.image)
        movieTagTextView.text = movie.tag
        movieDurationTextView.text = "${movie.duration} min"
        movieRatioTextView.text = "${movie.ratio}+"
        movieRatingRatingBar.numStars = movie.rating
        movieReviewTextView.text = "${movie.reviews}"
    }

}