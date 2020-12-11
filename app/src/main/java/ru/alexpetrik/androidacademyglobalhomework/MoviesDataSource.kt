package ru.alexpetrik.androidacademyglobalhomework

class MoviesDataSource {
    fun getMovies(): List<Movie> = listOf(
        Movie("Avengers: End Game",
            R.drawable.avengers_end_game_title,
            "Action, Adventure, Drama",
            137,
            13,
            4,
            125
        ),
        Movie("Tenet",
            R.drawable.tenet,
            "Action, Sci-Fi, Thriller",
            97,
            16,
            5,
            98
        ),
        Movie("Black Widow",
            R.drawable.black_widow,
            "Action, Adventure, Sci-Fi",
            102,
            13,
            4,
            38
        ),
        Movie("Wonder Woman 1984",
            R.drawable.wonder_woman,
            "Action, Adventure, Fantasy",
            120,
            13,
            3,
            74
            ),
    )
}