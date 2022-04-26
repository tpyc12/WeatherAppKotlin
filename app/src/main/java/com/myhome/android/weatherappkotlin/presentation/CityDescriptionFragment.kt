package com.myhome.android.weatherappkotlin.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.myhome.android.weatherappkotlin.R
import com.myhome.android.weatherappkotlin.databinding.FragmentCityDescriptionBinding
import com.myhome.android.weatherappkotlin.domain.entity.City

class CityDescriptionFragment : Fragment() {

    private lateinit var city: City

    private var _binding: FragmentCityDescriptionBinding? = null
    private val binding: FragmentCityDescriptionBinding
        get() = _binding ?: throw RuntimeException("FragmentCityDescriptionBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        parseArgs()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_app_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.info -> {
                launchFragment(InfoFragment.newInstance())
            true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityDescriptionBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBrowser.setOnClickListener {
            startBrowser()
        }
        binding.ivWeatherIcon.setImageResource(city.icon)
        binding.tvCityName.text = city.city
        binding.tvTemp.text = city.temp.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun launchFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.city_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun startBrowser() {
        val url = "https://yandex.ru/pogoda/"
        val uri = Uri.parse(url)
        val browser = Intent(Intent.ACTION_VIEW, uri)
        startActivity(browser)
    }

    private fun parseArgs() {
        requireArguments().getParcelable<City>(CITY)?.let {
            city = it
        }
    }

    companion object {
        const val CITY = "city"

        fun newInstance(city: City): Fragment {
            return CityDescriptionFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(CITY, city)
                }
            }
        }
    }
}