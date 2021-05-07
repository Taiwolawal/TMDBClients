package com.example.android.tmdbclients.data.repository.tvshow.datasourceimpl

import com.example.android.tmdbclients.data.api.TMDBService
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsRemoteDataSource
import com.example.android.tmdbclients.data.model.tvshow.TvShowList
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String):
    TvShowsRemoteDataSource {


    override suspend fun getTvShows(): Response<TvShowList> {
        return  tmdbService.getTvShows(apiKey)
    }
}