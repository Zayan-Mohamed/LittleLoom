package com.zayan.littleloom.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zayan.littleloom.R
import com.zayan.littleloom.databinding.FragmentActivitiesBinding
import com.zayan.littleloom.model.CardItem
import com.zayan.littleloom.ui.adapter.CardAdapter

class ActivitiesFragment : Fragment() {
    private var _binding: FragmentActivitiesBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)

        // Initialize RecyclerView
        recyclerView = binding.rvActivities
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Create example data
        val activityItems = createActivityItems()

        // Initialize adapter with activity items and click listener
        adapter = CardAdapter(activityItems) { item ->
            // Handle click on activity item and navigate to corresponding fragment
            Toast.makeText(context, "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()

            // Navigate based on item ID
            when (item.id) {
                1 -> findNavController().navigate(R.id.action_activitiesFragment_to_artsCraftsFragment)
                2 -> findNavController().navigate(R.id.action_activitiesFragment_to_learningGamesFragment)
                3 -> findNavController().navigate(R.id.action_activitiesFragment_to_outdoorActivitiesFragment)
                4 -> findNavController().navigate(R.id.action_activitiesFragment_to_storyTimeFragment)
                5 -> findNavController().navigate(R.id.action_activitiesFragment_to_musicDanceFragment)
            }
        }



        // Set the adapter to RecyclerView
        recyclerView.adapter = adapter

        return binding.root
    }

    private fun createActivityItems(): List<CardItem> {
        return listOf(
            CardItem(
                1,
                "Arts & Crafts",
                "Creative art activities for children",
                R.drawable.ic_arts_crafts
            ),
            CardItem(
                2,
                "Learning Games",
                "Educational games for development",
                R.drawable.ic_learning_games
            ),
            CardItem(
                3,
                "Outdoor Activities",
                "Physical activities for outdoor play",
                R.drawable.ic_outdoor_activities
            ),
            CardItem(
                4,
                "Story Time",
                "Interactive storytelling sessions",
                R.drawable.ic_story_time
            ),
            CardItem(
                5,
                "Music & Dance",
                "Rhythmic and movement activities",
                R.drawable.ic_music_dance
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
