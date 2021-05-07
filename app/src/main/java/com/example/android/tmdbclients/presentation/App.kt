package com.example.android.tmdbclients.presentation

import android.app.Application
import com.example.android.tmdbclients.BuildConfig
import com.example.android.tmdbclients.presentation.di.Injector
import com.example.android.tmdbclients.presentation.di.artist.ArtistSubComponent
import com.example.android.tmdbclients.presentation.di.core.*
import com.example.android.tmdbclients.presentation.di.movie.MovieSubComponent
import com.example.android.tmdbclients.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
               appComponent = DaggerAppComponent.builder()
           .appModule(AppModule(applicationContext))
           .netModule(NetModule(BuildConfig.BASE_URL))
           .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
           .build()

    }
    override fun createMovieSubComponent(): MovieSubComponent {
       return  appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return  appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return  appComponent.artistSubComponent().create()
    }
}