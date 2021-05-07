package com.example.android.tmdbclients.data.repository.tvshow.datasource

import com.example.android.tmdbclients.data.model.tvshow.TvShow

interface TvShowsCacheDataSource {

    suspend fun  getTvShowsFromCache(): List<TvShow>

    suspend fun  saveTvShowsToCache(tvShow: List<TvShow>)
}