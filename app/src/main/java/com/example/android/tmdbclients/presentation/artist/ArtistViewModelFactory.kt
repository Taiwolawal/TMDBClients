package com.example.android.tmdbclients.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.tmdbclients.domain.usecase.GetArtistUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedArtistUseCase

class ArtistViewModelFactory (
    private val getArtistUseCase: GetArtistUseCase,
    private val updatedArtistUseCase: GetUpdatedArtistUseCase
): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase, updatedArtistUseCase) as T
    }
}