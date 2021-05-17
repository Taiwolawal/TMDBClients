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

    override suspend fun getMovies(): List<Movie>? =  getMoviesFromCache()


    override suspend fun getUpdatedMovies(): List<Movie>? {
        val newMoviesList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMoviesList)
        movieCacheDataSource.saveMoviesToCache(newMoviesList)
        return newMoviesList
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null){
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
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
            moviesList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(moviesList)
        }
        return moviesList

    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var moviesList: List<Movie>
        try {
            moviesList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (moviesList.size > 0) {
            return moviesList
        } else {
            moviesList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(moviesList)
        }
        return moviesList
    }


}