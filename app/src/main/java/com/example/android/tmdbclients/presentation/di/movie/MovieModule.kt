package com.example.android.tmdbclients.presentation.di.movie

import com.example.android.tmdbclients.domain.usecase.GetMoviesUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedMoviesUseCase
import com.example.android.tmdbclients.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updatedMoviesUseCase: GetUpdatedMoviesUseCase
    ): MovieViewModelFactory {
        return  MovieViewModelFactory(getMoviesUseCase, updatedMoviesUseCase)
    }
}