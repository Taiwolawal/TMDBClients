package com.example.android.tmdbclients.data.repository.movie.datasource

import com.example.android.tmdbclients.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun  getMoviesFromCache(): List<Movie>

    suspend fun  saveMoviesToCache(movies: List<Movie>)
}