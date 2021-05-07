package com.example.android.tmdbclients.data.model.tvshow

import com.example.android.tmdbclients.data.model.tvshow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>
)