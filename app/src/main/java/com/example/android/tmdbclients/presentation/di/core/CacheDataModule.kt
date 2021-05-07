package com.example.android.tmdbclients.presentation.di.core

import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.android.tmdbclients.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieCacheDataSource
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieLocalDataSource
import com.example.android.tmdbclients.data.repository.movie.datasourceimpl.MoviesCacheDataSourceImpl
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.example.android.tmdbclients.data.repository.tvshow.datasourceimpl.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return  MoviesCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowsCacheDataSource{
        return  TvShowsCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return  ArtistCacheDataSourceImpl()
    }
}