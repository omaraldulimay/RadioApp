package com.example.radioapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.radioapp.ui.theme.RadioAppTheme
import com.IU.radioapp.R
import android.content.Intent
import android.widget.Button
import com.example.radioapp.RateHostActivity
import com.example.radioapp.SongWishActivity
import com.example.radioapp.RatePlaylistActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratePlaylistButton = findViewById<Button>(R.id.ratePlaylistButton)
        val submitRequestButton = findViewById<Button>(R.id.submitRequestButton)
        val rateModeratorButton = findViewById<Button>(R.id.rateModeratorButton)

        ratePlaylistButton.setOnClickListener {
            val intent = Intent(this, RatePlaylistActivity::class.java)
            startActivity(intent)
        }

        submitRequestButton.setOnClickListener {
            val intent = Intent(this, SongWishActivity::class.java)
            startActivity(intent)
        }

        rateModeratorButton.setOnClickListener {
            val intent = Intent(this, RateHostActivity::class.java)
            startActivity(intent)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RadioAppTheme {
        Greeting("Android")
    }
}
