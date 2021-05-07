package com.example.android.tmdbclients.data.repository.artist.datasource

import com.example.android.tmdbclients.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsToDB(artist: List<Artist>)

    suspend fun clearAll()
}