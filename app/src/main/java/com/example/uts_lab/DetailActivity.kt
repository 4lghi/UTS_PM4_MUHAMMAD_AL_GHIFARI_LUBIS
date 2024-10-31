package com.example.uts_lab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var judulTv: TextView
    private lateinit var tahunTv: TextView
    private lateinit var ratingTv: TextView
    private lateinit var genreTv: TextView
    private lateinit var synopsisTv: TextView
    private lateinit var trailerTv: TextView
    private lateinit var releaseDateTv: TextView
    private lateinit var directorTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Initialize your TextViews
        judulTv = findViewById(R.id.judul_tv)
        tahunTv = findViewById(R.id.tahun_tv)
        ratingTv = findViewById(R.id.rating)
        genreTv = findViewById(R.id.genre_tv)
        synopsisTv = findViewById(R.id.synopsis_content_tv)
        trailerTv = findViewById(R.id.trailer_content_tv)
        releaseDateTv = findViewById(R.id.release_content_tv) // Add this TextView in your layout
        directorTv = findViewById(R.id.director_content_tv) // Add this TextView in your layout

        // Get the data from the intent
        val judul = intent.getStringExtra("judul")
        val tahun = intent.getStringExtra("tahun")
        val rating = intent.getStringExtra("rating")
        val genre = intent.getStringExtra("genre")
        val synopsis = intent.getStringExtra("synopsis")
        val trailer = intent.getStringExtra("trailer")
        val releaseDate = intent.getStringExtra("releaseDate")
        val director = intent.getStringExtra("director")

        // Set the data to the TextViews
        judulTv.text = judul
        tahunTv.text = tahun
        ratingTv.text = rating
        genreTv.text = genre
        synopsisTv.text = synopsis
        trailerTv.text = trailer
        releaseDateTv.text = releaseDate
        directorTv.text = director

        trailerTv.setOnClickListener {
            trailer?.let {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                intent.setPackage("com.google.android.youtube") // Arahkan ke aplikasi YouTube
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                } else {
                    // Jika YouTube tidak tersedia, buka di browser
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
                }
            }
        }

    }
}
