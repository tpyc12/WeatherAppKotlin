package com.myhome.android.weatherappkotlin.data

import com.myhome.android.weatherappkotlin.R
import com.myhome.android.weatherappkotlin.domain.entity.City
import com.myhome.android.weatherappkotlin.domain.repository.Repository

object CityListRepositoryImpl : Repository {

    private val cityList = mutableListOf<City>()

    private var autoIncrementId = 0

    init {
        val cityMinsk = City("Minsk", 10, "10:20", "Cloudy", R.drawable.light_mode_48px)
        val cityMoscow = City("Moscow", -17, "10:20", "Sunny", R.drawable.light_mode_48px)
        val cityVegas = City("Vegas", 32, "10:20", "Sunny", R.drawable.light_mode_48px)
        val cityDubai = City("Dubai", 36, "10:20", "Sunny", R.drawable.light_mode_48px)

        cityList.add(cityMinsk)
        cityList.add(cityDubai)
        cityList.add(cityMoscow)
        cityList.add(cityVegas)
    }

    override fun getCityList(): List<City> {
        return cityList.toList()
    }

    override fun getCityWeatherInfo(cityId: Int): City {
        return cityList.find {
            it.id == cityId
        } ?: throw RuntimeException("City with $cityId not found")
    }

    override fun addCity(city: City) {
        city.id = autoIncrementId++
        cityList.add(city)
    }

    override fun deleteCity(city: City) {
        cityList.remove(city)
    }
}