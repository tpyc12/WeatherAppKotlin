package com.myhome.android.weatherappkotlin.domain.entity

data class City(
    val id: Int,
    val city: String,
    val temp: Int,
    val time: String,
    val description: String,
    val icon: String
)