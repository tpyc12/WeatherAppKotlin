package com.myhome.android.weatherappkotlin.domain.repository

import com.myhome.android.weatherappkotlin.domain.entity.City

interface Repository {

    fun getCityList(): List<City>

    fun getCityWeatherInfo(cityId: Int): City

    fun addCity(city: City)

    fun deleteCity(city: City)
}