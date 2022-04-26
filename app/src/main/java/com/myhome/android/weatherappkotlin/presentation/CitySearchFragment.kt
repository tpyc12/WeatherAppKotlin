package com.myhome.android.weatherappkotlin.presentation

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.myhome.android.weatherappkotlin.R
import com.myhome.android.weatherappkotlin.databinding.FragmentCitySearchBinding

class CitySearchFragment : Fragment() {

    private var _binding: FragmentCitySearchBinding? = null
    private val binding: FragmentCitySearchBinding
        get() = _binding ?: throw RuntimeException("FragmentCitySearchBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
        _binding = FragmentCitySearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            launchFragment(CityListFragment.newInstance())
        }
        binding.buttonSearch.setOnClickListener {
            Snackbar
                .make(binding.root, "Search", Snackbar.LENGTH_SHORT)
                .setAction("Action"){}
                .setAnchorView(it)
                .show()
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

    companion object {

        fun newInstance(): Fragment {
            return CitySearchFragment()
        }
    }
}