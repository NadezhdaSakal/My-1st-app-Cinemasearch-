package com.sakal_n.myapplicationcinemasearch.domain

import com.sakal_n.myapplicationcinemasearch.data.API
import com.sakal_n.myapplicationcinemasearch.data.MainRepository
import com.sakal_n.myapplicationcinemasearch.data.TmdbApi
import com.sakal_n.myapplicationcinemasearch.data.entity.Film
import com.sakal_n.myapplicationcinemasearch.data.entity.TmdbResults
import com.sakal_n.myapplicationcinemasearch.data.preferences.PreferenceProvider
import com.sakal_n.myapplicationcinemasearch.utils.Converter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {

    val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    var progressBarState = Channel<Boolean>(Channel.CONFLATED)

    fun getFilmsFromApi(page: Int) {
        //Показываем ProgressBar
        scope.launch {
            progressBarState.send(true)
        }
        //Метод getDefaultCategoryFromPreferences() будет нам получать при каждом запросе нужный нам список фильмов
        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResults> {
            override fun onResponse(call: Call<TmdbResults>, response: Response<TmdbResults>) {
                val list = Converter.convertApiListToDTOList(response.body()?.tmdbFilms)
                //Кладем фильмы в бд
                //В случае успешного ответа кладем фильмы в БД и выключаем ProgressBar
                scope.launch {
                    repo.putToDb(list)
                    progressBarState.send(false)
                }

            }

            override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                //В случае провала выключаем ProgressBar
                scope.launch {
                    progressBarState.send(false)
                }

            }
        })
    }
    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }
    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.geDefaultCategory()

    fun getFilmsFromDB(): Flow<List<Film>> = repo.getAllFromDB()


}

