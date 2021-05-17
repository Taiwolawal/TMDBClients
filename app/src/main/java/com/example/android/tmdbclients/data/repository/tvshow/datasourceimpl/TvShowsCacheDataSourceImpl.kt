package com.example.android.tmdbclients.data.repository.tvshow.datasourceimpl

import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.example.android.tmdbclients.data.model.tvshow.TvShow

class TvShowsCacheDataSourceImpl(): TvShowsCacheDataSource {

    private var tvShowsList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return  tvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}