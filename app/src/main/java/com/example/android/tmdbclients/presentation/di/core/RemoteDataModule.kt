package com.example.android.tmdbclients.presentation.di.core

import com.example.android.tmdbclients.data.api.TMDBService
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.android.tmdbclients.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.android.tmdbclients.data.repository.movie.datasourceimpl.MoviesRemoteDataSourceImpl
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsRemoteDataSource
import com.example.android.tmdbclients.data.repository.tvshow.datasourceimpl.TvShowsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return  MoviesRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowsRemoteDataSource{
        return  TvShowsRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource{
        return  ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }
}