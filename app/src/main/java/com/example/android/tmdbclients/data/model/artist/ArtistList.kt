package com.example.android.tmdbclients.data.model.artist

import com.example.android.tmdbclients.data.model.artist.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>

)