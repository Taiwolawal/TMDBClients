package com.example.android.tmdbclients.data.repository.artist.datasourceimpl

import com.example.android.tmdbclients.data.db.ArtistDao
import com.example.android.tmdbclients.data.model.artist.Artist
import com.example.android.tmdbclients.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> {
       return  artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}