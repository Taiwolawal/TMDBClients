package com.example.android.tmdbclients.data.repository.movie.datasourceimpl

import com.example.android.tmdbclients.data.api.TMDBService
import com.example.android.tmdbclients.data.model.movie.MovieList
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MoviesRemoteDataSourceImpl (private val tmdbService: TMDBService, private val apiKey: String):
    MovieRemoteDataSource {


    override suspend fun getMovies(): Response<MovieList> =  tmdbService.getPopularMovies(apiKey)

}