package dev.ogabek.test.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.ogabek.test.R
import dev.ogabek.test.databinding.FragmentOnBoardingBinding
import dev.ogabek.test.manager.SharedPref

class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        initViews()

        return binding.root

    }

    private fun initViews() {
        binding.btnGetStarted.setOnClickListener {
            SharedPref(requireContext()).saveBoolean("isOnBoardFinish", true)
            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
        }
    }

}