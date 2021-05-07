package com.example.android.tmdbclients.data.repository.artist.datasourceimpl

import com.example.android.tmdbclients.data.model.artist.Artist
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl(): ArtistCacheDataSource {

    private var artistList =  ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return  artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList =  ArrayList(artist)
    }
}