package com.zayan.littleloom.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.zayan.littleloom.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        // Setup card click listeners
        setupCardClickListeners(root)

        return root
    }

    private fun setupCardClickListeners(view: View) {
        // Daily Activities Card
        view.findViewById<CardView>(R.id.cardDailyActivities).setOnClickListener {
            Toast.makeText(context, "Daily Activities clicked", Toast.LENGTH_SHORT).show()
            // Navigate to the appropriate screen
            // Example: findNavController().navigate(R.id.action_home_to_dailyActivities)
        }

        // Attendance Card
        view.findViewById<CardView>(R.id.cardAttendance).setOnClickListener {
            Toast.makeText(context, "Attendance Tracker clicked", Toast.LENGTH_SHORT).show()
            // Navigate to the appropriate screen
            // Example: findNavController().navigate(R.id.action_home_to_attendance)
        }

        // Add more card listeners as needed
    }
}