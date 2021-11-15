package com.sakal_n.myapplicationcinemasearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sakal_n.myapplicationcinemasearch.App
import com.sakal_n.myapplicationcinemasearch.domain.Film
import com.sakal_n.myapplicationcinemasearch.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData:  MutableLiveData<List<Film>> = MutableLiveData()
    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor

    init {
        val films = interactor.getFilmsDB()
        filmsListLiveData.postValue(films)
    }
}




