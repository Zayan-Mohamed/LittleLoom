package com.zayan.littleloom.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zayan.littleloom.R
import com.zayan.littleloom.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    // Use nullable binding to follow lifecycle best practices
    private var _binding: FragmentHomeBinding? = null

    // Non-null getter for the binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout and initialize the binding object
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Set up card configurations
        setupCardConfigurations()

        // Set up listeners for the cards
        setupCardClickListeners()

        return binding.root
    }

    private fun setupCardConfigurations() {
        // Rooms Card
        configureCard(
            binding.cardRooms.root,
            "Rooms",
            "Manage and view rooms",
            R.drawable.ic_rooms
        )

        // Reminders Card
        configureCard(
            binding.cardReminders.root,
            "Reminders",
            "View and manage your reminders",
            R.drawable.ic_reminders
        )

        // Room Check Card
        configureCard(
            binding.cardRoomCheck.root,
            "Room Check",
            "Perform room inspections",
            R.drawable.ic_room_check
        )

        // Staff Card
        configureCard(
            binding.cardStaff.root,
            "Staff",
            "Manage staff information",
            R.drawable.ic_staff
        )

        // Check In/Out Card
        configureCard(
            binding.cardCheckInOut.root,
            "Check In/Out",
            "Manage check-in and check-out",
            R.drawable.ic_check_in_out
        )

        // Invite Parents Card
        configureCard(
            binding.cardInviteParents.root,
            "Invite Parents",
            "Send invitations to parents",
            R.drawable.ic_invite_parents
        )
    }

    private fun configureCard(
        cardView: View,
        title: String,
        description: String,
        iconResId: Int
    ) {
        cardView.findViewById<TextView>(R.id.tvTitle).text = title
        cardView.findViewById<TextView>(R.id.tvDescription).text = description
        cardView.findViewById<ImageView>(R.id.ivIcon).setImageResource(iconResId)
    }

    private fun setupCardClickListeners() {
        // Rooms Card
        binding.cardRooms.root.setOnClickListener {
            Toast.makeText(context, "Navigating to Rooms", Toast.LENGTH_SHORT).show()
            // Add navigation logic for Rooms
        }

        // Reminders Card
        binding.cardReminders.root.setOnClickListener {
            Toast.makeText(context, "Navigating to Reminders", Toast.LENGTH_SHORT).show()
            // Add navigation logic for Reminders
        }

        // Room Check Card
        binding.cardRoomCheck.root.setOnClickListener {
            Toast.makeText(context, "Navigating to Room Check", Toast.LENGTH_SHORT).show()
            // Add navigation logic for Room Check
        }

        // Staff Card
        binding.cardStaff.root.setOnClickListener {
            Toast.makeText(context, "Navigating to Staff", Toast.LENGTH_SHORT).show()
            // Add navigation logic for Staff
        }

        // Check In/Out Card
        binding.cardCheckInOut.root.setOnClickListener {
            Toast.makeText(context, "Navigating to Check In/Out", Toast.LENGTH_SHORT).show()
            // Add navigation logic for Check In/Out
        }

        // Invite Parents Card
        binding.cardInviteParents.root.setOnClickListener {
            Toast.makeText(context, "Navigating to Invite Parents", Toast.LENGTH_SHORT).show()
            // Add navigation logic for Invite Parents
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the binding to avoid memory leaks
        _binding = null
    }
}