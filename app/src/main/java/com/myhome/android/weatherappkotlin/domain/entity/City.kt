package com.myhome.android.weatherappkotlin.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val city: String,
    val temp: Int,
    val time: String,
    val description: String,
    val icon: Int,
    var id: Int = UNDEFINED_ID
): Parcelable {
    companion object{
        private const val UNDEFINED_ID = -1
    }
}