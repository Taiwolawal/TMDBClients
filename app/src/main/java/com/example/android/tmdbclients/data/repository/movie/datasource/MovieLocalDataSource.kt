package com.example.android.tmdbclients.data.repository.movie.datasource

import com.example.android.tmdbclients.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(artist: List<Movie>)

    suspend fun clearAll()
}