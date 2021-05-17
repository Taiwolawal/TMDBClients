package com.example.android.tmdbclients.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.tmdbclients.domain.usecase.GetMoviesUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getUpdatedMoviesUseCase: GetUpdatedMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = getUpdatedMoviesUseCase.execute()
        emit(movieList)
    }
}