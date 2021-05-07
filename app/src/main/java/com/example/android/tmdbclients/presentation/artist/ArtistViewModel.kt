package com.example.android.tmdbclients.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.tmdbclients.domain.usecase.GetArtistUseCase
import com.example.android.tmdbclients.domain.usecase.GetUpdatedArtistUseCase

class ArtistViewModel (
    private val getArtistUseCase: GetArtistUseCase,
    private val updatedArtistUseCase: GetUpdatedArtistUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updatedArtistUseCase.execute()
        emit(artistList)
    }
}