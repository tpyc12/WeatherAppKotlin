package com.myhome.android.weatherappkotlin.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myhome.android.weatherappkotlin.R
import com.myhome.android.weatherappkotlin.databinding.FragmentInfoBinding
import java.lang.RuntimeException

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding: FragmentInfoBinding
    get() = _binding ?: throw RuntimeException("FragmentInfoBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        fun newInstance(): Fragment{
            return InfoFragment()
        }
    }
}