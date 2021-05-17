package com.example.android.tmdbclients.data.repository.artist.datasource

import com.example.android.tmdbclients.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun  getArtistFromCache(): List<Artist>

    suspend fun  saveArtistToCache(artists: List<Artist>)
}