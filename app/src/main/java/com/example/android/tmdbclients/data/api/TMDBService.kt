package com.example.android.tmdbclients.data.api

import com.example.android.tmdbclients.data.model.artist.ArtistList
import com.example.android.tmdbclients.data.model.movie.MovieList
import com.example.android.tmdbclients.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("/tv/popular")
    suspend fun getTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("/person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>
}