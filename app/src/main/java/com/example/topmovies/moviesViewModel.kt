package com.example.topmovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class moviesViewModel:ViewModel()
{
    var movies = MutableLiveData<ArrayList<Movie>>()

    fun getMovies()= CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.moviesApi.getMovies()
            if (response.isSuccessful)
            {
                CoroutineScope(Dispatchers.Main).launch {
                    movies.value = response.body()
                }
            }else{

            }
        }catch (e:Exception){}
    }
}