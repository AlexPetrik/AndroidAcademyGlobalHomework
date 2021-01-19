package ru.alexpetrik.androidacademyglobalhomework.db

object MovieDbContract {

    const val ACTOR_TABLE_NAME = "actors.db"
    const val GENRE_TABLE_NAME = "genres.db"
    const val MOVIE_TABLE_NAME = "movies"
    const val MOVIE_GENRE_TABLE_NAME = "Movies_Genres.db"
    const val MOVIE_ACTOR_TABLE_NAME = "Movies_Actors.db"

    object ActorContract {
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_PROFILE = "profile_path"
    }

    object GenreContract {
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_NAME = "name"
    }

    object MovieContract {
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_OVERVIEW = "overview"
        const val COLUMN_NAME_POSTER = "poster"
        const val COLUMN_NAME_BACKDROP = "title"
        const val COLUMN_NAME_RATINGS = "ratings"
        const val COLUMN_NAME_NUMBER_RATINGS = "number_ratings"
        const val COLUMN_NAME_AGE = "age"
        const val COLUMN_NAME_RUNTIME = "runtime"
    }

    object MovieGenreJoinContract {
        const val COLUMN_NAME_MOVIE_ID = "movie_id"
        const val COLUMN_NAME_GENRE_ID = "genre_id"
    }

    object MovieActorJoinContract {
        const val COLUMN_NAME_MOVIE_ID = "movie_id"
        const val COLUMN_NAME_ACTOR_ID = "actor_id"
    }

}