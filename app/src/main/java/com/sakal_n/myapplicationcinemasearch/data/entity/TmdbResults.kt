package com.sakal_n.myapplicationcinemasearch.data.entity

import com.google.gson.annotations.SerializedName


class TmdbResults (
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val tmdbFilms: List<TmdbFilm>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
    )

