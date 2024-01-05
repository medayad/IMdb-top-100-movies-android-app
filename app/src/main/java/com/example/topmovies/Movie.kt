package com.example.topmovies

data class Movie (
    val rank: Int,
    val image : String,
    val genre : ArrayList<String>,
    val title : String,
    val rating : String,
    val year : String
        )
