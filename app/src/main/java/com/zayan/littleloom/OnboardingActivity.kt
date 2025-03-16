package com.zayan.littleloom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.zayan.littleloom.databinding.ActivityOnboardingBinding
import com.google.android.material.button.MaterialButton

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var nextButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.onboardingViewPager
        nextButton = binding.nextButton

        // Set up the ViewPager with onboarding fragments
        val onboardingFragments = listOf(
            OnboardingFragment.newInstance("Welcome to LittleLoom!", "Manage your daycare with ease.", 0), // Pass position 0
            OnboardingFragment.newInstance("Track Activities", "Keep track of children's daily activities.", 1), // Pass position 1
            OnboardingFragment.newInstance("Stay Connected", "Communicate with parents effortlessly.", 2) // Pass position 2
        )

        val adapter = OnboardingPagerAdapter(this, onboardingFragments)
        viewPager.adapter = adapter

        // Handle "Next" button click
        nextButton.setOnClickListener {
            if (viewPager.currentItem < onboardingFragments.size - 1) {
                viewPager.currentItem += 1
            } else {
                // Navigate to the main activity or login screen
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }
    }
}