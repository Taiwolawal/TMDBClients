package com.example.android.tmdbclients.data.repository.movie.datasource

import com.example.android.tmdbclients.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}