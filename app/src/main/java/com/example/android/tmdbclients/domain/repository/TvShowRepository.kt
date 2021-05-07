package com.example.android.tmdbclients.domain.repository

import com.example.android.tmdbclients.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun  getUpdatedTvShows(): List<TvShow>?
}