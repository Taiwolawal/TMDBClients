package com.example.android.tmdbclients.data.repository.artist.datasourceimpl

import com.example.android.tmdbclients.data.api.TMDBService
import com.example.android.tmdbclients.data.model.artist.ArtistList
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String):
    ArtistRemoteDataSource {

    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}