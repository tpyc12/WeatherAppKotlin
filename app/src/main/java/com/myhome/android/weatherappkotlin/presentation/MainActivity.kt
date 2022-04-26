package com.myhome.android.weatherappkotlin.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.myhome.android.weatherappkotlin.R
import com.myhome.android.weatherappkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    launchFragment(CityListFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
                R.id.info -> {
                    launchFragment(InfoFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
                R.id.settings -> {
                    launchFragment(SettingsFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
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


    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.city_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}