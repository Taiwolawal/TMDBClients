package com.example.android.tmdbclients.presentation.di

import com.example.android.tmdbclients.presentation.di.artist.ArtistSubComponent
import com.example.android.tmdbclients.presentation.di.movie.MovieSubComponent
import com.example.android.tmdbclients.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}