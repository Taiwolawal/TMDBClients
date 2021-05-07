package com.example.android.tmdbclients.presentation.di.core

import com.example.android.tmdbclients.data.db.ArtistDao
import com.example.android.tmdbclients.data.db.MovieDao
import com.example.android.tmdbclients.data.db.TvShowDao
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.android.tmdbclients.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieLocalDataSource
import com.example.android.tmdbclients.data.repository.movie.datasourceimpl.MoviesLocalDataSourceImpl
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.example.android.tmdbclients.data.repository.tvshow.datasourceimpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return  MoviesLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowsLocalDataSource{
        return  TvShowsLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return  ArtistLocalDataSourceImpl(artistDao)
    }
}