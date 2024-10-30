package com.example.uts_lab

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.rvPoster.setImageResource(currentItem.poster)
        holder.rvJudul.text = currentItem.judul
        holder.rvTahun.text = currentItem.tahun

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("judul", currentItem.judul)
                putExtra("tahun", currentItem.tahun)
                putExtra("rating", currentItem.rating)
                putExtra("genre", currentItem.genre)
                putExtra("synopsis", currentItem.synopsis)
                putExtra("trailer", currentItem.trailer)
                putExtra("releaseDate", currentItem.releaseDate)
                putExtra("director", currentItem.director)
            }
            context.startActivity(intent)
        }
    }


    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvPoster: ImageView = itemView.findViewById(R.id.poster_movie)
        val rvJudul: TextView = itemView.findViewById(R.id.judul_movie)
        val rvTahun: TextView = itemView.findViewById(R.id.tahun_movie)
    }

}
