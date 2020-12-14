package ru.alexpetrik.androidacademyglobalhomework

class MoviesDataSource {
    fun getMovies(): List<Movie> = listOf(
        Movie("Avengers: End Game",
            R.drawable.avengers_end_game_title,
            "Action, Adventure, Drama",
            137,
            13,
            4,
            125,
            R.string.after_the_dev,
            listOf(Actor(
                "Robert Downey Jr.",
                R.drawable.robert_downey_jr
                ),
                Actor(
                    "Chris Evans",
                    R.drawable.chris_evans
                ),
                Actor(
                    "Mark Ruffalo",
                    R.drawable.mark_ruffalo
                ),
                Actor(
                    "Chris Hemsworth",
                    R.drawable.chris_hemsworth
                ),
            )
        ),
        Movie("Tenet",
            R.drawable.tenet,
            "Action, Sci-Fi, Thriller",
            97,
            16,
            5,
            98,
            actors = listOf(Actor(
                "Robert Downey Jr.",
                R.drawable.robert_downey_jr
                ),
              Actor(
                    "Mark Ruffalo",
                    R.drawable.mark_ruffalo
                ),
                Actor(
                    "Chris Hemsworth",
                    R.drawable.chris_hemsworth
                )
            )
        ),
        Movie("Black Widow",
            R.drawable.black_widow,
            "Action, Adventure, Sci-Fi",
            102,
            13,
            4,
            38,
            actors = listOf(Actor(
                "Robert Downey Jr.",
                R.drawable.robert_downey_jr
                ),
                Actor(
                    "Chris Evans",
                    R.drawable.chris_evans
                ),
                Actor(
                    "Mark Ruffalo",
                    R.drawable.mark_ruffalo
                )
            )
        ),
        Movie("Wonder Woman 1984",
            R.drawable.wonder_woman,
            "Action, Adventure, Fantasy",
            120,
            13,
            3,
            74,
            actors = listOf(Actor(
                "Robert Downey Jr.",
                R.drawable.robert_downey_jr
                ),
                Actor(
                    "Mark Ruffalo",
                    R.drawable.mark_ruffalo
                ),
                Actor(
                    "Chris Hemsworth",
                    R.drawable.chris_hemsworth
                ),
            )
        ),
    )
}