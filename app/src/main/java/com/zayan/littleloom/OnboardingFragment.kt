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
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        // Select the correct gradient based on page index
        val background = when (position) {
            0 -> R.drawable.gradient_neg45 // -45°
            1 -> R.drawable.gradient_90    // 90°
            2 -> R.drawable.gradient_45    // 45°
            else -> R.drawable.gradient_neg45
        }

        // Set background dynamically
        binding.gradientRectangle.setBackgroundResource(background)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.title.text = title
        binding.description.text = description

        // Select the correct image based on page index
        val imageRes = when (position) {
            0 -> R.drawable.ic_onboarding_1
            1 -> R.drawable.ic_onboarding_2
            2 -> R.drawable.ic_onboarding_3
            else -> R.drawable.ic_onboarding_1
        }

        // Set the image dynamically
        binding.onboardingImage.setImageResource(imageRes)

        // Show "Get Started" button only on the last onboarding page
        if (position == 2) {
            binding.getStartedButton.visibility = View.VISIBLE
            binding.getStartedButton.setOnClickListener {
                startActivity(Intent(requireContext(), HomeActivity::class.java))
                requireActivity().finish()
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
            return OnboardingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_DESCRIPTION, description)
                    putInt(ARG_POSITION, position)
                }
            }
        }
    }
}
