package com.example.android.tmdbclients.presentation.di.artist

import com.example.android.tmdbclients.domain.usecase.GetArtistUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedArtistUseCase
import com.example.android.tmdbclients.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updatedArtistUseCase: GetUpdatedArtistUseCase
    ): ArtistViewModelFactory{
        return  ArtistViewModelFactory(getArtistUseCase, updatedArtistUseCase)
    }
}