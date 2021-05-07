package com.example.android.tmdbclients.data.repository.movie.datasourceimpl

import com.example.android.tmdbclients.data.model.movie.Movie
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieCacheDataSource

class MoviesCacheDataSourceImpl(): MovieCacheDataSource {

    private var moviesList = ArrayList<Movie>()

    override suspend fun getMovieFromCache(): List<Movie> {
        return  moviesList
    }

    override suspend fun saveMovieToCache(movie: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movie)
    }
}