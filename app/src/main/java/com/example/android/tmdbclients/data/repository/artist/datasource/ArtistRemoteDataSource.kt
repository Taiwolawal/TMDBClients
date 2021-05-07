package com.example.android.tmdbclients.data.repository.artist.datasource

import com.example.android.tmdbclients.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtist(): Response<ArtistList>
}