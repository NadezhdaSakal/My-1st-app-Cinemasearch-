package com.sakal_n.myapplicationcinemasearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sakal_n.myapplicationcinemasearch.App
import com.sakal_n.myapplicationcinemasearch.data.entity.Film
import com.sakal_n.myapplicationcinemasearch.domain.Interactor
import java.util.concurrent.Executors
import javax.inject.Inject


class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData: MutableLiveData<List<Film>> = MutableLiveData()

    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor

    init {
        App.instance.dagger.inject(this)
        getFilms()
    }

    fun getFilms() {


        interactor.getFilmsFromApi(1, object : ApiCallback {
            override fun onSuccess(films: List<Film>) {
                filmsListLiveData.postValue(films)
            }

            override fun onFailure() {
                Executors.newSingleThreadExecutor().execute {
                    filmsListLiveData.postValue(interactor.getFilmsFromDB())
                }

            }
        })
    }

    interface ApiCallback {
        fun onSuccess(films: List<Film>)
        fun onFailure()

    }
}




