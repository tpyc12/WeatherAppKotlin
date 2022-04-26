package com.myhome.android.weatherappkotlin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myhome.android.weatherappkotlin.R
import com.myhome.android.weatherappkotlin.databinding.ItemCityBinding
import com.myhome.android.weatherappkotlin.domain.entity.City

class CityAdapter : RecyclerView.Adapter<CityAdapter.CityItemViewHolder>() {

    var cities: List<City> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCityClickListener: ((City) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityItemViewHolder {
        val binding = ItemCityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CityItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityItemViewHolder, position: Int) {
        val city = cities[position]
        with(holder.binding) {
            tvCityName.text = city.city
            ivWeatherIcon.setImageResource(R.drawable.light_mode_48px)
            tvTemp.text = city.temp.toString()
            root.setOnClickListener {
                onCityClickListener?.invoke(city)
            }
        }
    }

    override fun getItemCount() = cities.size

    class CityItemViewHolder(val binding: ItemCityBinding) :
        RecyclerView.ViewHolder(binding.root)
}