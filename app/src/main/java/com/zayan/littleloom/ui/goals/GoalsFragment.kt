package com.zayan.littleloom.ui.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zayan.littleloom.databinding.FragmentGoalsBinding

class GoalsFragment : Fragment() {
    private var _binding: FragmentGoalsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGoalsBinding.inflate(inflater, container, false)

        // Set up checkboxes and tips
        setupGoals()

        return binding.root
    }

    private fun setupGoals() {
        // Handle checkbox clicks and show tips (or perform any other necessary action)
        binding.cbGoal1.setOnCheckedChangeListener { _, isChecked ->
            // Show or hide the tip based on checkbox state
            binding.tvGoal1Tip.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        binding.cbGoal2.setOnCheckedChangeListener { _, isChecked ->
            binding.tvGoal2Tip.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        binding.cbGoal3.setOnCheckedChangeListener { _, isChecked ->
            binding.tvGoal3Tip.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
