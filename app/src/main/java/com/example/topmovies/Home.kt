package com.example.topmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //

        val manager = GridLayoutManager(this,3)
        movies_displayer.layoutManager = manager
        val moviesVM = ViewModelProvider(this)[moviesViewModel::class.java]
        moviesVM.getMovies()
        moviesVM.movies.observe(this) {movies ->
            if(movies!=null){
                progressBar.visibility = View.GONE
                movies_displayer.adapter = MovieAdapter(this, movies)
            }

        }
    }
}