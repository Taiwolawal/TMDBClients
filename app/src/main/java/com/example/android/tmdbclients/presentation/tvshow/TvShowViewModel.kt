package com.example.android.tmdbclients.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.tmdbclients.domain.usecase.GetTvShowsUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedTvShowUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updatedTvShowUseCase: GetUpdatedTvShowUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updatedTvShowUseCase.execute()
        emit(tvShowList)
    }
}