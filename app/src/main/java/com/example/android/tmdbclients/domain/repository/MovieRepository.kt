package com.example.android.tmdbclients.domain.repository

import com.example.android.tmdbclients.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun  getUpdatedMovies(): List<Movie>?
}