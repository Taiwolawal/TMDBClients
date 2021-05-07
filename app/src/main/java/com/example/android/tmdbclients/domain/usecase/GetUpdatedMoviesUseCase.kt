package com.example.android.tmdbclients.domain.usecase

import com.example.android.tmdbclients.data.model.movie.Movie
import com.example.android.tmdbclients.domain.repository.MovieRepository

class GetUpdatedMoviesUseCase (private  val movieRepository: MovieRepository){

    suspend fun execute(): List<Movie> ? = movieRepository.getMovies()
}