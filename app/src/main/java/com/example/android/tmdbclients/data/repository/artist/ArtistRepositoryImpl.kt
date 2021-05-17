package com.example.android.tmdbclients.data.repository.artist

import android.util.Log
import com.example.android.tmdbclients.data.model.artist.Artist
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.android.tmdbclients.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun getUpdatedArtists(): List<Artist>? {
        val newArtistList = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newArtistList)
        artistCacheDataSource.saveArtistToCache(newArtistList)
        return newArtistList
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList

    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}