package com.zayan.littleloom.ui.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zayan.littleloom.databinding.FragmentMessagesBinding

class MessagesFragment : Fragment() {
    private var _binding: FragmentMessagesBinding? = null
    private val binding get() = _binding!!

    private lateinit var messagesAdapter: MessagesAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Sample messages for demonstration
        val sampleMessages = listOf(
            Message("1", "John Doe", "Hey, how are you?", System.currentTimeMillis(), false),
            Message("2", "Jane Smith", "Meeting at 3 PM", System.currentTimeMillis(), true),
            Message("3", "Mike Johnson", "Project update", System.currentTimeMillis(), false)
        )

        messagesAdapter = MessagesAdapter(sampleMessages) { message ->
            // Handle message item click
            // For example, navigate to message details or show dialog
        }

        recyclerView = binding.recyclerViewMessages
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = messagesAdapter

        // Show/hide no messages text based on list
        binding.tvNoMessages.visibility = if (messagesAdapter.itemCount == 0) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}