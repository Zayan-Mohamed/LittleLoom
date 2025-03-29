package com.zayan.littleloom.ui.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zayan.littleloom.databinding.FragmentGoalsBinding

class GoalsFragment : Fragment() {
    private var _binding: FragmentGoalsBinding? = null
    private val binding get() = _binding!!

    private lateinit var goalsAdapter: GoalsAdapter
    private lateinit var tipsAdapter: TipsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupToggleSwitch()
    }

    private fun setupRecyclerView() {
        // Goals
        val sampleGoals = listOf(
            Goal("1", "Complete daily meditation"),
            Goal("2", "Read for 30 minutes"),
            Goal("3", "Exercise for 45 minutes")
        )

        goalsAdapter = GoalsAdapter(sampleGoals) { goal, isCompleted ->
            // Handle goal completion (e.g., update in database)
            // You can add logic to track goal progress
        }

        // Tips
        val sampleTips = listOf(
            Tip("1", "Hydration Tip", "Drink at least 8 glasses of water daily to maintain optimal hydration."),
            Tip("2", "Mental Health", "Practice mindfulness for 10 minutes each day to reduce stress."),
            Tip("3", "Sleep Hygiene", "Maintain a consistent sleep schedule, even on weekends.")
        )

        tipsAdapter = TipsAdapter(sampleTips)

        binding.recyclerViewGoalsAndTips.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = goalsAdapter // Default to Goals
        }
    }

    private fun setupToggleSwitch() {
        binding.switchGoalsAndTips.setOnCheckedChangeListener { _, isChecked ->
            // Toggle between Goals and Tips
            binding.recyclerViewGoalsAndTips.adapter = if (isChecked) {
                tipsAdapter
            } else {
                goalsAdapter
            }

            // Update title based on current view
            binding.tvGoalsAndTipsTitle.text = if (isChecked) "Daily Tips" else "Your Goals"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}