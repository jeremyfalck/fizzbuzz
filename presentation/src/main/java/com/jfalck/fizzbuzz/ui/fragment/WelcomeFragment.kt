package com.jfalck.fizzbuzz.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jfalck.fizzbuzz.R
import com.jfalck.fizzbuzz.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint


private const val ANIMATION_DURATION = 3000L
private const val START_ALPHA = 0f
private const val END_ALPHA = 1f

@AndroidEntryPoint
class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentWelcomeBinding.inflate(layoutInflater).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AlphaAnimation(START_ALPHA, END_ALPHA).apply {
            duration = ANIMATION_DURATION
            binding.fragmentWelcomeTitle.startAnimation(this)
        }
        delayNavigation()
    }

    private fun delayNavigation() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_welcomeFragment_to_fizzBuzzListFragment)
        }, ANIMATION_DURATION)


    }
}