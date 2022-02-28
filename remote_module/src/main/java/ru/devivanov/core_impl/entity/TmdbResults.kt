package ru.devivanov.core_impl.entity

import com.google.gson.annotations.SerializedName


class TmdbResults (
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val tmdbFilms: List<ru.devivanov.core_impl.entity.TmdbFilm>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
    )

