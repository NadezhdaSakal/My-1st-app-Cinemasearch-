package ru.devivanov.core_impl

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import io.reactivex.rxjava3.core.Observable
import ru.devivanov.core_impl.entity.TmdbResults



interface TmdbApi {
    @GET("3/movie/{category}")
    fun getFilms(
        @Path("category") category: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Observable<TmdbResults>

    @GET("3/search/movie")
    fun getFilmFromSearch(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("page") page: Int
    ): Observable<TmdbResults>

}
