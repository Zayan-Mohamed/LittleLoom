package com.zayan.littleloom.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zayan.littleloom.R
import com.zayan.littleloom.model.CardItem
import com.example.littleloom.ui.adapter.CardAdapter

class ActivitiesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_activities, container, false)

        // Initialize RecyclerView
        recyclerView = root.findViewById(R.id.rvActivities)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Create example data
        val activityItems = createActivityItems()

        // Initialize adapter
        adapter = CardAdapter(activityItems) { item ->
            // Handle click on activity item
            Toast.makeText(context, "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()
            // Navigate to detailed view
            // Example: findNavController().navigate(R.id.action_activities_to_activityDetail)
        }

        recyclerView.adapter = adapter

        return root
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
}