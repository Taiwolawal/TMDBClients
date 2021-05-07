package com.example.android.tmdbclients.data.repository.movie

import android.util.Log
import com.example.android.tmdbclients.data.model.movie.Movie
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieCacheDataSource
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieLocalDataSource
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.android.tmdbclients.domain.repository.MovieRepository
import java.lang.Exception

class MoviesRepositoryImpl (private val movieRemoteDataSource: MovieRemoteDataSource,
                            private val movieLocalDataSource: MovieLocalDataSource,
                            private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun getUpdatedMovies(): List<Movie>? {
        val newMoviesList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMoviesList)
        movieCacheDataSource.saveMovieToCache(newMoviesList)
        return newMoviesList
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var moviesList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                moviesList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return moviesList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var moviesList: List<Movie>
        try {
            moviesList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (moviesList.size > 0) {
            return moviesList
        } else {
            moviesList = getMoviesFromDB()
            movieLocalDataSource.saveMoviesToDB(moviesList)
        }
        return moviesList

    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var moviesList: List<Movie>
        try {
            moviesList = movieCacheDataSource.getMovieFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (moviesList.size > 0) {
            return moviesList
        } else {
            moviesList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(moviesList)
        }
        return moviesList
    }


}