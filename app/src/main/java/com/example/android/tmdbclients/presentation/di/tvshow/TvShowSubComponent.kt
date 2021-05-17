package com.example.android.tmdbclients.presentation.di.tvshow

import com.example.android.tmdbclients.presentation.di.artist.ArtistScope
import com.example.android.tmdbclients.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}