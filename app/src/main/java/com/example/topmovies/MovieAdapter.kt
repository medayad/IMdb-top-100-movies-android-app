package com.example.topmovies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter (val context : Context, var data: ArrayList<Movie>) : RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_movie,parent,false)
        )
    }



    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movie_title.text = "${data[position].title}"
        for (genre in data[position].genre){
            holder.movie_genre.text = "${holder.movie_genre.text}$genre,"
        }
        holder.movie_genre.text = holder.movie_genre.text.toString().subSequence(0,holder.movie_genre.text.toString().length-1)
        Picasso.get().load(data[position].image).into(holder.movie_image)
        holder.movie_year.text=" (${data[position].year})"
        holder.movie_rating.text=data[position].rating

    }

    override fun getItemCount(): Int {
        return data.size
    }
}