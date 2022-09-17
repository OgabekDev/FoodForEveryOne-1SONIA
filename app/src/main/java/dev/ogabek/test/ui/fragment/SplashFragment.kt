package dev.ogabek.test.ui.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.ogabek.test.R
import dev.ogabek.test.manager.SharedPref

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCountDown()

    }

    private fun setCountDown() {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val onBoardFinish = SharedPref(requireContext()).getBoolean("isOnBoardFinish")
                val isLoggedIn = SharedPref(requireContext()).getBoolean("isLoggedIn")
                if (!onBoardFinish) {
                    findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
                } else if (isLoggedIn) {
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }
            }
        }.start()
    }

}