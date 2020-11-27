package ru.alexpetrik.androidacademyglobalhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val back_btn = findViewById<TextView>(R.id.movie_detail_back_tv)
        back_btn.setOnClickListener {
            onBackPressed()
        }
    }
}