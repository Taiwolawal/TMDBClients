package com.example.android.tmdbclients.domain.usecase

import com.example.android.tmdbclients.data.model.tvshow.TvShow
import com.example.android.tmdbclients.domain.repository.TvShowRepository

class GetUpdatedTvShowUseCase(private  val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getUpdatedTvShows()
}