package com.myhome.android.weatherappkotlin.domain.usecases

import com.myhome.android.weatherappkotlin.domain.repository.Repository

class GetCityListUseCase(
    private val repository: Repository
) {
    operator fun invoke() = repository.getCityList()
}
