package com.myhome.android.weatherappkotlin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myhome.android.weatherappkotlin.data.CityListRepositoryImpl
import com.myhome.android.weatherappkotlin.domain.entity.City
import com.myhome.android.weatherappkotlin.domain.usecases.AddCityUseCase
import com.myhome.android.weatherappkotlin.domain.usecases.DeleteCityUseCase
import com.myhome.android.weatherappkotlin.domain.usecases.GetCityListUseCase

class MainViewModel: ViewModel() {

    private val repository = CityListRepositoryImpl

    private val getCityListUseCase = GetCityListUseCase(repository)
    private val deleteCityUseCase = DeleteCityUseCase(repository)

    val cityList = MutableLiveData<List<City>>()

    fun getCityList(){
        val list = getCityListUseCase.invoke()
        cityList.value = list
    }

    fun deleteCity(city: City){
        deleteCityUseCase.invoke(city)
        getCityList()
    }
}