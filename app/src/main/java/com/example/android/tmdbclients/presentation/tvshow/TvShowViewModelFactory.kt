package com.example.android.tmdbclients.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.tmdbclients.domain.usecase.GetTvShowsUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedTvShowUseCase

class TvShowViewModelFactory (
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updatedTvShowUseCase: GetUpdatedTvShowUseCase
): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updatedTvShowUseCase) as T
    }
}