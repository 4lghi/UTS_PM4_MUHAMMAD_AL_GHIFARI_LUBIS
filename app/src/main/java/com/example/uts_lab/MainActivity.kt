package com.example.uts_lab

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieList: ArrayList<Movie>
    lateinit var posterList: Array<Int>
    lateinit var judulList: Array<String>
    lateinit var tahunList: Array<String>
    lateinit var ratingList: Array<String>
    lateinit var genreList: Array<String>
    lateinit var synopsisList: Array<String>
    lateinit var trailerList: Array<String>
    lateinit var releaseDateList: Array<String>
    lateinit var directorList: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        posterList = arrayOf(
            R.drawable.poster1,
            R.drawable.poster2,
            R.drawable.poster3,
            R.drawable.poster4,
            R.drawable.poster5,
            R.drawable.poster6,
            R.drawable.poster7,
            R.drawable.poster8,
            R.drawable.poster9
        )

        judulList =  arrayOf(
            "Jaws",
            "Parasite",
            "Birdman",
            "Ant-Man",
            "Handmaiden",
            "Black Swan",
            "Dune",
            "John Wick 2",
            "The G.S."
        )

        tahunList = arrayOf(
            "1975",  // year for Jaws
            "2019",  // year for Parasite
            "2014",  // year for Birdman
            "2015",  // year for Ant-Man
            "2016",  // year for The Handmaiden
            "2010",  // year for Black Swan
            "2021",  // year for Dune
            "2017",  // year for John Wick: Chapter 2
            "2017"   // year for The Greatest Showman
        )

        ratingList = arrayOf("8.0/10", "8.6/10", "7.7/10", "7.3/10", "8.1/10", "8.0/10", "8.0/10", "7.5/10", "7.6/10")
        genreList = arrayOf(
            "Thriller, Adventure",               // Jaws
            "Drama, Thriller",                   // Parasite
            "Drama, Comedy",                     // Birdman
            "Action, Adventure, Comedy",         // Ant-Man
            "Drama, Mystery, Romance",           // The Handmaiden
            "Drama, Thriller",                   // Black Swan
            "Sci-Fi, Adventure, Action",         // Dune
            "Action, Thriller",                  // John Wick: Chapter 2
            "Drama, Musical, Biography"          // The Greatest Showman
        )

        synopsisList = arrayOf(
            "A giant shark terrorizes a small beach town, leading to a summer of terror for locals and tourists.",
            "A poor family schemes to become employed by a wealthy family and infiltrate their household.",
            "A washed-up actor known for a superhero role struggles to mount a Broadway play while dealing with his ego.",
            "A former thief turned superhero must reclaim his identity and save the world by shrinking down to size.",
            "In 1930s Korea, a conman poses as a Japanese nobleman to win the heart of a rich heiress.",
            "A ballerina's obsession with perfection leads her down a dark path as she prepares for a major role.",
            "In a dystopian future, a young man must navigate a dangerous desert planet to find a precious resource.",
            "Hitman John Wick is forced back into the criminal underworld he left behind after a blood oath.",
            "The story of P.T. Barnum's creation of the circus and the lives of the performers who made it unique."
        )

        trailerList = arrayOf(
            "https://www.youtube.com/watch?v=U1fu_sA7XhE", // Jaws
            "https://www.youtube.com/watch?v=SEUXfv87Wpk", // Parasite
            "https://www.youtube.com/watch?v=uJfLoE6hanc", // Birdman
            "https://www.youtube.com/watch?v=pWdKf3MneyI", // Ant-Man
            "https://www.youtube.com/watch?v=whldChqCsYk", // The Handmaiden
            "https://www.youtube.com/watch?v=5jaI1XOB-bs", // Black Swan
            "https://www.youtube.com/watch?v=n9xhJrPXop4", // Dune
            "https://www.youtube.com/watch?v=XGk2EfbD_Ps", // John Wick: Chapter 2
            "https://www.youtube.com/watch?v=EodWwczRIe4"  // The Greatest Showman
        )

        releaseDateList = arrayOf(
            "1975-06-20", // Jaws
            "2019-05-30", // Parasite
            "2014-10-17", // Birdman
            "2015-07-17", // Ant-Man
            "2016-06-01", // The Handmaiden
            "2010-12-03", // Black Swan
            "2021-10-22", // Dune
            "2017-02-10", // John Wick: Chapter 2
            "2017-12-20"  // The Greatest Showman
        )

        directorList = arrayOf(
            "Steven Spielberg",        // Jaws
            "Bong Joon-ho",           // Parasite
            "Alejandro G. Iñárritu",  // Birdman
            "Peyton Reed",            // Ant-Man
            "Park Chan-wook",         // The Handmaiden
            "Darren Aronofsky",       // Black Swan
            "Denis Villeneuve",       // Dune
            "Chad Stahelski",         // John Wick: Chapter 2
            "Michael Gracey"          // The Greatest Showman
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.addItemDecoration(MarginItemDecoration(18)) // Menggunakan 16dp sebagai contoh jarak
        recyclerView.setHasFixedSize(true)

        movieList = arrayListOf<Movie>()
        getData()

    }


    class MarginItemDecoration(
        private val spacing: Int
    ) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.left = spacing
            outRect.right = spacing
            outRect.top = spacing
            outRect.bottom = spacing
        }
    }


    private fun getData() {
        for (i in posterList.indices) {
            val movie = Movie(
                judulList[i],
                tahunList[i],
                posterList[i],
                ratingList[i],
                genreList[i],
                synopsisList[i],
                trailerList[i],
                releaseDateList[i],
                directorList[i]
            )
            movieList.add(movie)
        }
        recyclerView.adapter = MovieAdapter(movieList)
    }

}