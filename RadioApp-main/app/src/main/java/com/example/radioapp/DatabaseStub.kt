package com.example.radioapp

import com.google.firebase.firestore.FirebaseFirestore
        class DatabaseStub {
            private val Firebase: FirebaseFirestore by lazy {
                FirebaseFirestore.getInstance()
            }

            fun submitSongWish(name: String, songName: String, artistName: String) {
                val songWish: MutableMap<String, Any> = HashMap()
                songWish["name"] = name
                songWish["songName"] = songName
                songWish["artistName"] = artistName

                Firebase.collection("songWishes")
                    .add(songWish)
                    .addOnSuccessListener { documentReference ->
                        println("Song wish submitted with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        println("Error submitting song wish: $e")
                    }
            }

            fun ratePlaylist(rating: Int) {
                val playlistRating: MutableMap<String, Any> = HashMap()
                playlistRating["rating"] = rating

                Firebase.collection("playlistRatings")
                    .add(playlistRating)
                    .addOnSuccessListener { documentReference ->
                        println("Playlist rated with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        println("Error rating playlist: $e")
                    }
            }

            fun rateModerator(rating: Int) {
                val moderatorRating: MutableMap<String, Any> = HashMap()
                moderatorRating["rating"] = rating

                Firebase.collection("moderatorRatings")
                    .add(moderatorRating)
                    .addOnSuccessListener { documentReference ->
                        println("Moderator rated with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        println("Error rating moderator: $e")
                    }
            }




            fun storeHostRating(rating: Float) {
                val hostRating: MutableMap<String, Any> = HashMap()
                hostRating["rating"] = rating

                Firebase.collection("hostRatings")
                    .add(hostRating)
                    .addOnSuccessListener { documentReference ->
                        println("Host rating stored with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        println("Error storing host rating: $e")
                    }
            }

            fun readSongWishes() {
                Firebase.collection("songWishes")
                    .get()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            task.result?.let { result ->
                                for (document in result) {
                                    println("${document.id} => ${document.data}")
                                }
                            } ?: println("Error: task result is null")
                        } else {
                            println("Error getting documents: ${task.exception}")
                        }
                    }
            }
        }



    // ... similar methods for read}
