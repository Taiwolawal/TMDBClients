package com.example.android.tmdbclients.data.repository.movie.datasourceimpl

import com.example.android.tmdbclients.data.db.MovieDao
import com.example.android.tmdbclients.data.model.movie.Movie
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesLocalDataSourceImpl (private val movieDao: MovieDao): MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return  movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movie)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }


}