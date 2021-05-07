package com.example.android.tmdbclients.presentation.di.core

import com.example.android.tmdbclients.data.repository.artist.ArtistRepositoryImpl
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.android.tmdbclients.data.repository.movie.MoviesRepositoryImpl
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieCacheDataSource
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieLocalDataSource
import com.example.android.tmdbclients.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.android.tmdbclients.data.repository.tvshow.TvShowsRepositoryImpl
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.example.android.tmdbclients.data.repository.tvshow.datasource.TvShowsRemoteDataSource
import com.example.android.tmdbclients.domain.repository.ArtistRepository
import com.example.android.tmdbclients.domain.repository.MovieRepository
import com.example.android.tmdbclients.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MoviesRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
       artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvsShowRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCacheDataSource: TvShowsCacheDataSource
    ): TvShowRepository{
        return TvShowsRepositoryImpl(
            tvShowsRemoteDataSource,
            tvShowsLocalDataSource,
            tvShowsCacheDataSource
        )
    }
}