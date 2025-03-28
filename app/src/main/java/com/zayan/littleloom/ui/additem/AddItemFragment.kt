package com.zayan.littleloom.ui.additem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zayan.littleloom.databinding.FragmentAddItemBinding

class AddItemFragment : Fragment() {
    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val itemName = binding.etItemName.text.toString()
            val itemDescription = binding.etItemDescription.text.toString()

            // Validate and save item
            if (validateInput(itemName, itemDescription)) {
                saveItem(itemName, itemDescription)
            }
        }
    }

    private fun validateInput(name: String, description: String): Boolean {
        return when {
            name.isEmpty() -> {
                binding.tilItemName.error = "Item name cannot be empty"
                false
            }
            description.isEmpty() -> {
                binding.tilItemDescription.error = "Description cannot be empty"
                false
            }
            else -> true
        }
    }

    private fun saveItem(name: String, description: String) {
        // Implement your save logic here
        // This could involve calling a ViewModel, Repository, or making an API call
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}