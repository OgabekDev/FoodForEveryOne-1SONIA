package dev.ogabek.test.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.ogabek.test.R
import dev.ogabek.test.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.apply {
            icBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

}