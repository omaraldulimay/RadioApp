package com.example.radioapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.IU.radioapp.R

class SongWishActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_wish)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val songInput = findViewById<EditText>(R.id.songInput)
        val artistInput = findViewById<EditText>(R.id.artistInput)
        val submitButton = findViewById<Button>(R.id.submitWishButton)

        // Create an instance of DatabaseStub
        val dbStub = DatabaseStub()
        // read the song wishes using the stub
        dbStub.readSongWishes()

        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val song = songInput.text.toString()
            val artist = artistInput.text.toString()

            Toast.makeText(
                this,
                "Song Wunsch abgegeben!: $name, $song, $artist",
                Toast.LENGTH_SHORT
            ).show()

            // Store the song wish using the stub
            dbStub.submitSongWish(name, song, artist)


        }

        val goBackButton = findViewById<Button>(R.id.goBackButton)
        goBackButton.setOnClickListener {
            finish()
        }
    }
}