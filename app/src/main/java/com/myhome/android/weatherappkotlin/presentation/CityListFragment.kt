package com.myhome.android.weatherappkotlin.presentation

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.myhome.android.weatherappkotlin.R
import com.myhome.android.weatherappkotlin.databinding.FragmentCityListBinding
import com.myhome.android.weatherappkotlin.presentation.adapter.CityAdapter

class CityListFragment : Fragment() {

    private var _binding: FragmentCityListBinding? = null
    private val binding: FragmentCityListBinding
        get() = _binding ?: throw RuntimeException("FragmentCityListBinding == null")

    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    private lateinit var cityListAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.cityList.observe(viewLifecycleOwner){
            Log.d("CityListFragment", it.toString())
            cityListAdapter.cities = it
        }
        cityListAdapter.onCityClickListener = {
            launchFragment(CityDescriptionFragment.newInstance(it))
        }
        viewModel.getCityList()

        binding.floatingActionButton.setOnClickListener {
            launchFragment(CitySearchFragment.newInstance())
        }
    }

    private fun setupRecyclerView() {
        val rvCityList = binding.rvCityList
        with(rvCityList){
            cityListAdapter = CityAdapter()
            cityListAdapter.cities
            adapter = cityListAdapter
        }
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

    companion object{

        fun newInstance(): Fragment{
            return CityListFragment()
        }
    }
}