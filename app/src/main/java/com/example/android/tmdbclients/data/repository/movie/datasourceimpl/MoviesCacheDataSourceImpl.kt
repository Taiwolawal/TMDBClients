package com.example.android.tmdbclients.data.repository.movie.datasourceimpl

import com.example.android.tmdbclients.data.model.movie.Movie
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieCacheDataSource

class MoviesCacheDataSourceImpl(): MovieCacheDataSource {

    private var moviesList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return  moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}