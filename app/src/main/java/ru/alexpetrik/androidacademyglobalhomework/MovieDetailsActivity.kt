package ru.alexpetrik.androidacademyglobalhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val back_btn = findViewById<Button>(R.id.movie_detail_back_button)
        back_btn.setOnClickListener {
            onBackPressed()
        }
    }
}