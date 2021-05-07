package com.example.android.tmdbclients.domain.repository

import com.example.android.tmdbclients.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun  getUpdatedArtists(): List<Artist>?
}