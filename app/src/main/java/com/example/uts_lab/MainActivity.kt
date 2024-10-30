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
            R.drawable.poster1,
            R.drawable.poster2,
            R.drawable.poster3,
            R.drawable.poster4
        )

        judulList =  arrayOf(
            "Jaws",
            "Parasite",
            "Birdman",
            "Ant-Man",
            "Handmaiden",
            "Jaws",
            "Parasite",
            "Birdman",
            "Ant-Man"
        )

        tahunList = arrayOf(
            "2002",
            "2004",
            "2022",
            "2000",
            "1999",
            "2002",
            "2004",
            "2022",
            "2000"
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


    private fun getData (){
        for (i in posterList.indices){
            val movie = Movie(judulList[i], tahunList[i], posterList[i])
            movieList.add(movie)
        }
        recyclerView.adapter = MovieAdapter(movieList)
    }
}