package com.zayan.littleloom.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.zayan.littleloom.R
import com.zayan.littleloom.databinding.FragmentActivitiesBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ActivitiesFragment : Fragment() {
    private var _binding: FragmentActivitiesBinding? = null
    private val binding get() = _binding!!

    private lateinit var activitiesAdapter: ActivitiesAdapter
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val sectionFormat = SimpleDateFormat("EEEE, MMMM d", Locale.getDefault())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSortSpinner()
        setupRecyclerView()
    }

    private fun setupSortSpinner() {
        val sortOptions = arrayOf(
            "Most Recent",
            "Room Name",
            "Category"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            sortOptions
        )
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerSort.adapter = adapter
    }

    private fun setupRecyclerView() {
        // Sample activities for demonstration
        val sampleActivities = generateSampleActivities()

        // Group activities by date
        val groupedActivities = sampleActivities.groupBy {
            getActivityDateSection(it.timestamp)
        }

        activitiesAdapter = ActivitiesAdapter(sampleActivities) { activity ->
            // Handle activity item click
        }

        binding.recyclerViewActivities.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = activitiesAdapter

            // Add section dividers
            val divider = MaterialDividerItemDecoration(
                requireContext(),
                MaterialDividerItemDecoration.VERTICAL
            )
            addItemDecoration(divider)
        }

        // TODO: Implement sorting logic based on spinner selection
        binding.spinnerSort.setSelection(0) // Default to Most Recent
    }

    private fun generateSampleActivities(): List<Activity> {
        val now = System.currentTimeMillis()
        return listOf(
            // Today's activities
            Activity("1", "Morning Health Check", ActivityCategory.HEALTH, "Alpha", now - 2 * 60 * 60 * 1000),
            Activity("2", "Achievement Review", ActivityCategory.ACHIEVEMENT, "Beta", now - 4 * 60 * 60 * 1000),

            // Yesterday's activities
            Activity("3", "Medical Spot Check", ActivityCategory.MEDICAL, "Alpha", now - 24 * 60 * 60 * 1000 - 3 * 60 * 60 * 1000),
            Activity("4", "Wellness Assessment", ActivityCategory.HEALTH, "Beta", now - 24 * 60 * 60 * 1000 - 6 * 60 * 60 * 1000)
        )
    }

    private fun getActivityDateSection(timestamp: Long): String {
        val calendar = Calendar.getInstance()
        calendar.time = Date(timestamp)

        val today = Calendar.getInstance()
        val yesterday = Calendar.getInstance()
        yesterday.add(Calendar.DAY_OF_YEAR, -1)

        return when {
            dateFormat.format(calendar.time) == dateFormat.format(today.time) -> "Today"
            dateFormat.format(calendar.time) == dateFormat.format(yesterday.time) -> "Yesterday"
            else -> sectionFormat.format(calendar.time)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}