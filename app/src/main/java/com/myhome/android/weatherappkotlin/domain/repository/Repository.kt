package com.myhome.android.weatherappkotlin.domain.repository

import androidx.lifecycle.LiveData
import com.myhome.android.weatherappkotlin.domain.entity.City

interface Repository {

    fun getCityList(): LiveData<List<City>>

    fun getCityWeatherInfo(cityId: Int): LiveData<City>

    fun addCity(city: City)

    fun deleteCity(city: City)
}