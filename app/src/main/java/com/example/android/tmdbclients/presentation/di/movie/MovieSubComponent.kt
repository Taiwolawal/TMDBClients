package com.example.android.tmdbclients.presentation.di.movie

import com.example.android.tmdbclients.presentation.artist.ArtistActivity
import com.example.android.tmdbclients.presentation.di.artist.ArtistModule
import com.example.android.tmdbclients.presentation.di.artist.ArtistScope
import com.example.android.tmdbclients.presentation.di.artist.ArtistSubComponent
import com.example.android.tmdbclients.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface  MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}