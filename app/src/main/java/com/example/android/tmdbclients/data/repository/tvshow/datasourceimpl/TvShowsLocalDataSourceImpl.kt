package com.example.android.tmdbclients.data.repository.tvshow.datasourceimpl

import com.example.android.tmdbclients.data.db.TvShowDao
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.example.android.tmdbclients.data.model.tvshow.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl (private val tvShowDao: TvShowDao): TvShowsLocalDataSource {


    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShow()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }

}