package com.example.android.tmdbclients.domain.usecase

import com.example.android.tmdbclients.data.model.artist.Artist
import com.example.android.tmdbclients.domain.repository.ArtistRepository

class GetArtistUseCase (private val artistRepository: ArtistRepository) {

    suspend fun  execute(): List<Artist>? = artistRepository.getArtists()
}