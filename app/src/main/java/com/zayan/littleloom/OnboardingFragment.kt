package com.zayan.littleloom

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zayan.littleloom.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    private var title: String? = null
    private var description: String? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            description = it.getString(ARG_DESCRIPTION)
            position = it.getInt(ARG_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.title.text = title
        binding.description.text = description

        // Show the "Get Started" button only on the last onboarding page
        if (position == 2) { // Assuming 3 onboarding pages (0, 1, 2)
            binding.getStartedButton.visibility = View.VISIBLE
            binding.getStartedButton.setOnClickListener {
                // Navigate to the Home Screen
                startActivity(Intent(requireContext(), HomeActivity::class.java))
                requireActivity().finish() // Close the onboarding activity
            }
        } else {
            binding.getStartedButton.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_DESCRIPTION = "description"
        private const val ARG_POSITION = "position"

        fun newInstance(title: String, description: String, position: Int): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_DESCRIPTION, description)
            args.putInt(ARG_POSITION, position)
            fragment.arguments = args
            return fragment
        }
    }
}