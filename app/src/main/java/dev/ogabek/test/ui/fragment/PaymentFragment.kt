package dev.ogabek.test.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.ogabek.test.R
import dev.ogabek.test.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment(R.layout.fragment_payment) {

    private lateinit var binding: FragmentPaymentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPaymentBinding.inflate(inflater, container, false)

        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.apply {
            icBack.setOnClickListener {
                requireActivity().onBackPressed()
            }

            llBank.setOnClickListener {
                rbBank.isChecked = true
                rbCard.isChecked = false
            }

            llCard.setOnClickListener {
                rbBank.isChecked = false
                rbCard.isChecked = true
            }

            rbBank.setOnClickListener {
                rbBank.isChecked = true
                rbCard.isChecked = false
            }

            rbCard.setOnClickListener {
                rbBank.isChecked = false
                rbCard.isChecked = true
            }

            llRoom.setOnClickListener {
                rbRoom.isChecked = true
                rbPickUp.isChecked = false
            }

            llPickUp.setOnClickListener {
                rbRoom.isChecked = false
                rbPickUp.isChecked = true
            }

            rbRoom.setOnClickListener {
                rbRoom.isChecked = true
                rbPickUp.isChecked = false
            }

            rbPickUp.setOnClickListener {
                rbRoom.isChecked = false
                rbPickUp.isChecked = true
            }

        }
    }

}