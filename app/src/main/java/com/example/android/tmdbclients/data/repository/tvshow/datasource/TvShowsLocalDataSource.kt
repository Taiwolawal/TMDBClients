package com.example.android.tmdbclients.data.repository.tvshow.datasource

import com.example.android.tmdbclients.data.model.tvshow.TvShow

interface TvShowsLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun saveTvShowsToDB(tvShow: List<TvShow>)

    suspend fun clearAll()
}