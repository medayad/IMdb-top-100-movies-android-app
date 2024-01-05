package com.example.topmovies

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface moviesApi
{ @Headers("X-RapidAPI-Key: 3f038b462dmsh90126a788f12322p1db1ebjsn6cdf040130f0",
    "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com",
    "Content-type: application/json")
    @GET(".")
    suspend fun getMovies()
    :Response<ArrayList<Movie>>



}