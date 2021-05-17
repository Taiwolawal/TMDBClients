package com.example.android.tmdbclients.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.tmdbclients.domain.usecase.GetMoviesUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedMoviesUseCase

class MovieViewModelFactory (
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getUpdatedMoviesUseCase: GetUpdatedMoviesUseCase
        ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  MovieViewModel(getMoviesUseCase, getUpdatedMoviesUseCase) as T
    }
}