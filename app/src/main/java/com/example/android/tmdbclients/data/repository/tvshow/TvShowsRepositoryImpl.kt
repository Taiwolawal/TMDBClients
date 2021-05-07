package com.example.android.tmdbclients.data.repository.tvshow

import android.util.Log
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsRemoteDataSource
import com.example.android.tmdbclients.data.model.tvshow.TvShow
import com.example.android.tmdbclients.domain.repository.TvShowRepository

class TvShowsRepositoryImpl (private val tvShowsRemoteDataSource: TvShowsRemoteDataSource,
                             private val tvShowsLocalDataSource: TvShowsLocalDataSource,
                             private val tvShowsCacheDataSource: TvShowsCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return  getTvShowsFromCache()
    }

    override suspend fun getUpdatedTvShows(): List<TvShow>? {
        val newTvShowsList = getTvShowsFromAPI()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowsToDB(newTvShowsList)
        tvShowsCacheDataSource.saveTvShowsToCache(newTvShowsList)
        return newTvShowsList
    }


    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            val response = tvShowsRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowsList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowsLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowsList.size > 0) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromDB()
            tvShowsLocalDataSource.saveTvShowsToDB(tvShowsList)
        }
        return tvShowsList

    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowsCacheDataSource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowsList.size > 0) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromDB()
            tvShowsCacheDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }


}