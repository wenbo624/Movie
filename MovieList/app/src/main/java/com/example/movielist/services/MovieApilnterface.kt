package com.example.movielist.services

import com.example.movielist.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApilnterface{
    @GET("/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed")
    fun getMovieList(): Call<MovieResponse>
}