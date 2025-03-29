package com.zayan.littleloom.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zayan.littleloom.R
import com.zayan.littleloom.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

//        setupNavigation()

        // Set up any additional logic (like settings options, preferences)
        // Example: binding.someSettingOption.setOnClickListener {...}

        return binding.root
    }

//    private fun setupNavigation() {
//        // Navigate back to the home screen (example of how to go back)
//        binding.btnBackHome.setOnClickListener {
//            findNavController().navigate(R.id.action_settingsFragment_to_homeFragment)
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
