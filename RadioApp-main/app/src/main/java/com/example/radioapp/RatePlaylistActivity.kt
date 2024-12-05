package com.example.radioapp

import android.content.Intent
import android.widget.Toast
import android.widget.Button
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.IU.radioapp.R
import com.example.radioapp.ui.theme.RadioAppTheme
import android.widget.RatingBar

class RatePlaylistActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_playlist)

        val submitButton = findViewById<Button>(R.id.submitRatingButton)
        submitButton.setOnClickListener {
            // Handle button click here
            // For example, you can show a toast message
            Toast.makeText(this, "Bewertung abgegeben!", Toast.LENGTH_SHORT).show()

            // Create an intent to start the main activity
            val intent = Intent(this, MainActivity::class.java)

            // Start the main activity
            startActivity(intent)

            // Finish the current activity
            finish()
            // Find the RatingBar widget by its ID
            val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

            // Get the current rating value from the RatingBar
            val rating = ratingBar.rating.toInt()

            // Create an instance of DatabaseStub
            val dbStub = DatabaseStub()

            // Call the ratePlaylist method with the rating value
            dbStub.ratePlaylist(rating)

        }

        val goBackButton = findViewById<Button>(R.id.goBackButton)
        goBackButton.setOnClickListener {
            finish()
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    RadioAppTheme {
        Greeting2("Android")
    }
}