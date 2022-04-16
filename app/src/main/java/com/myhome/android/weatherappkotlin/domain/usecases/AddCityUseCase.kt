package com.myhome.android.weatherappkotlin.domain.usecases

import com.myhome.android.weatherappkotlin.domain.entity.City
import com.myhome.android.weatherappkotlin.domain.repository.Repository

class AddCityUseCase(
    private val repository: Repository
) {

    operator fun invoke(city: City) {
        repository.addCity(city)
    }
}