package com.example.android.tmdbclients.data.repository.tvshow.datasource

import com.example.android.tmdbclients.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowsRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>
}
