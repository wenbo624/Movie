package com.example.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.models.Movie
import com.example.movielist.models.MovieResponse
import com.example.movielist.services.MovieApiService
import com.example.movielist.services.MovieApilnterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieDate { movies:List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }

    }
    private fun getMovieDate(callback:(List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApilnterface::class.java)
        apiService.getMovieList().enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
        })
    }
}