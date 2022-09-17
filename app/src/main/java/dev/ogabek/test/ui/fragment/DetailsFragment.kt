package dev.ogabek.test.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dev.ogabek.test.R
import dev.ogabek.test.adapter.DetailsAdapter
import dev.ogabek.test.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding

    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        initViews()

        return binding.root

    }

    private fun initViews() {
        binding.apply {
            val adapter = DetailsAdapter(args.meal.images)
            viewPager.adapter = adapter

            dotsx.setViewPager2(viewPager)

            tvName.text = args.meal.name
            tvPrice.text = args.meal.price
            tvDeliveryInfo.text = args.meal.deliveryInfo
            tvReturnPolice.text = args.meal.returnPolicy

            binding.icBack.setOnClickListener {
                requireActivity().onBackPressed()
            }

            binding.btnAddToCart.setOnClickListener {
                findNavController().navigate(R.id.action_detailsFragment_to_cartFragment)
            }

        }
    }

}