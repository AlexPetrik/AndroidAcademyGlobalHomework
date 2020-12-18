package ru.alexpetrik.androidacademyglobalhomework

class MoviesDataSource {
    fun getMovies(): List<Movie> = listOf(
        Movie(movieName = "Avengers: End Game",
            image = R.drawable.avengers_end_game_title,
            tag = "Action, Adventure, Drama",
            duration = 137,
            ratio = 13,
            rating = 4,
            reviews = 125,
            R.string.after_the_dev,
            listOf(Actor(
                    name = "Robert Downey Jr.",
                    photo = R.drawable.robert_downey_jr
                ),
                Actor(
                    name = "Chris Evans",
                    photo = R.drawable.chris_evans
                ),
                Actor(
                    name = "Mark Ruffalo",
                    photo = R.drawable.mark_ruffalo
                ),
                Actor(
                    name = "Chris Hemsworth",
                    photo = R.drawable.chris_hemsworth
                ),
                Actor(
                    name = "Chris Evans",
                    photo = R.drawable.chris_evans
                ),
                Actor(
                    name = "Mark Ruffalo",
                    photo = R.drawable.mark_ruffalo
                )
            )
        ),
        Movie(movieName = "Tenet",
            image = R.drawable.tenet,
            tag = "Action, Sci-Fi, Thriller",
            duration = 97,
            ratio = 16,
            rating = 5,
            reviews = 98,
            actors = listOf(Actor(
                    name = "Robert Downey Jr.",
                    photo = R.drawable.robert_downey_jr
                ),
              Actor(
                  name = "Mark Ruffalo",
                  photo = R.drawable.mark_ruffalo
                ),
                Actor(
                    name = "Chris Hemsworth",
                    photo = R.drawable.chris_hemsworth
                )
            )
        ),
        Movie(movieName = "Black Widow",
            image = R.drawable.black_widow,
            tag = "Action, Adventure, Sci-Fi",
            duration = 102,
            ratio = 13,
            rating = 4,
            reviews = 38,
            actors = listOf(Actor(
                    name = "Robert Downey Jr.",
                    photo = R.drawable.robert_downey_jr
                ),
                Actor(
                    name = "Chris Evans",
                    photo = R.drawable.chris_evans
                ),
                Actor(
                    name = "Mark Ruffalo",
                    photo = R.drawable.mark_ruffalo
                )
            )
        ),
        Movie(movieName = "Wonder Woman 1984",
            image = R.drawable.wonder_woman,
            tag = "Action, Adventure, Fantasy",
            duration = 120,
            ratio = 13,
            rating = 3,
            reviews = 74,
            actors = listOf(Actor(
                    name = "Robert Downey Jr.",
                    photo = R.drawable.robert_downey_jr
                ),
                Actor(
                    name = "Mark Ruffalo",
                    photo = R.drawable.mark_ruffalo
                ),
                Actor(
                    name = "Chris Hemsworth",
                    photo = R.drawable.chris_hemsworth
                ),
            )
        ),
        Movie(movieName = "Avengers: End Game",
            image = R.drawable.avengers_end_game_title,
            tag = "Action, Adventure, Drama",
            duration = 137,
            ratio = 13,
            rating = 4,
            reviews = 125,
            R.string.after_the_dev,
            listOf(Actor(
                name = "Robert Downey Jr.",
                photo = R.drawable.robert_downey_jr
            ),
                Actor(
                    name = "Chris Evans",
                    photo = R.drawable.chris_evans
                ),
                Actor(
                    name = "Mark Ruffalo",
                    photo = R.drawable.mark_ruffalo
                ),
                Actor(
                    name = "Chris Hemsworth",
                    photo = R.drawable.chris_hemsworth
                ),
                Actor(
                    name = "Chris Evans",
                    photo = R.drawable.chris_evans
                ),
                Actor(
                    name = "Mark Ruffalo",
                    photo = R.drawable.mark_ruffalo
                )
            )
        ),
        Movie(movieName = "Tenet",
            image = R.drawable.tenet,
            tag = "Action, Sci-Fi, Thriller",
            duration = 97,
            ratio = 16,
            rating = 5,
            reviews = 98,
            actors = listOf(Actor(
                name = "Robert Downey Jr.",
                photo = R.drawable.robert_downey_jr
            ),
                Actor(
                    name = "Mark Ruffalo",
                    photo = R.drawable.mark_ruffalo
                ),
                Actor(
                    name = "Chris Hemsworth",
                    photo = R.drawable.chris_hemsworth
                )
            )
        )
    )
}