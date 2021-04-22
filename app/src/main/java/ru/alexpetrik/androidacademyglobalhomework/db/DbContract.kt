package ru.alexpetrik.androidacademyglobalhomework.db

object DbContract {

    const val DATA_BASE_NAME = "movie_list_database"

    const val ACTOR_TABLE_NAME = "actors"
    const val GENRE_TABLE_NAME = "genres"
    const val MOVIE_TABLE_NAME = "movies"
    const val MOVIE_GENRE_TABLE_NAME = "movies_genres"
    const val MOVIE_ACTOR_TABLE_NAME = "movies_actors"

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
        const val COLUMN_NAME_BACKDROP = "backdrop"
        const val COLUMN_NAME_RATINGS = "ratings"
        const val COLUMN_NAME_NUMBER_RATINGS = "number_ratings"
        const val COLUMN_NAME_AGE = "age"
        const val COLUMN_NAME_RUNTIME = "runtime"
    }

    object MovieGenreJoinContract {
        const val COLUMN_NAME_MOVIE_ID = "movie_id"
        const val COLUMN_NAME_GENRE_ID = "genre_id"
        const val COLUMN_NAME_GENRE_NAME = "genre_name"
    }

    object MovieActorJoinContract {
        const val COLUMN_NAME_MOVIE_ID = "movie_id"
        const val COLUMN_NAME_ACTOR_ID = "actor_id"
    }

}