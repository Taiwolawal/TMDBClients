package com.example.android.tmdbclients.presentation.di.tvshow

import com.example.android.tmdbclients.domain.usecase.GetTvShowsUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedTvShowUseCase
import com.example.android.tmdbclients.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updatedTvShowUseCase: GetUpdatedTvShowUseCase
    ): TvShowViewModelFactory {
        return  TvShowViewModelFactory(getTvShowsUseCase, updatedTvShowUseCase)
    }
}