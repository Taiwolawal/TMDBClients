package com.example.android.tmdbclients.presentation.di.core

import com.example.android.tmdbclients.domain.repository.ArtistRepository
import com.example.android.tmdbclients.domain.repository.MovieRepository
import com.example.android.tmdbclients.domain.repository.TvShowRepository
import com.example.android.tmdbclients.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUSeCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): GetUpdatedMoviesUseCase{
        return  GetUpdatedMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistUSeCase(artistRepository: ArtistRepository): GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): GetUpdatedArtistUseCase{
        return  GetUpdatedArtistUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowUSeCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):GetUpdatedTvShowUseCase{
        return  GetUpdatedTvShowUseCase(tvShowRepository)
    }
}