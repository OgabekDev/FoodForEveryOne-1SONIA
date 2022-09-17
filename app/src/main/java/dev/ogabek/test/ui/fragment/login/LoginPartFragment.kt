package dev.ogabek.test.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dev.ogabek.test.R
import dev.ogabek.test.databinding.FragmentLoginBinding
import dev.ogabek.test.databinding.FragmentLoginPartBinding
import dev.ogabek.test.manager.SharedPref

class LoginPartFragment : Fragment(R.layout.fragment_login_part) {

    private lateinit var binding: FragmentLoginPartBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginPartBinding.inflate(inflater, container, false)

        initViews()

        return binding.root
    }

    private fun initViews() {
        binding.apply {
            btnLogin.setOnClickListener {
                if (etEmail.text.isNullOrEmpty() || etPassword.text.isNullOrEmpty()) {
                    Snackbar.make(binding.root, "Please fill the fields", Snackbar.LENGTH_SHORT).show()
                } else {
                    SharedPref(requireContext()).saveBoolean("isLoggedIn", true)
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }
            }
        }
    }

}