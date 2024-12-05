package com.example.radioapp

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.IU.radioapp.R


class RateHostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_host)

        val ratingBar = findViewById<RatingBar>(R.id.hostRatingBar)
        val submitButton = findViewById<Button>(R.id.submitRatingButton)

        submitButton.setOnClickListener {
            val rating = ratingBar.rating
            Toast.makeText(this, "Bewertung abgegeben!: $rating", Toast.LENGTH_SHORT).show()

            // Create an instance of DatabaseStub
            val dbStub = DatabaseStub()
            // Store the rating using the stub
            dbStub.storeHostRating(rating)
            // Rate the moderator using the stub
            dbStub.rateModerator(rating.toInt())
        }
        val goBackButton = findViewById<Button>(R.id.goBackButton)
        goBackButton.setOnClickListener {
            finish()
        }
    }
}