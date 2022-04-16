package com.myhome.android.weatherappkotlin.domain.usecases

import com.myhome.android.weatherappkotlin.domain.repository.Repository

class GetCityUseCase(
    private val repository: Repository
) {

    operator fun invoke(cityId: Int) = repository.getCityWeatherInfo(cityId)
}