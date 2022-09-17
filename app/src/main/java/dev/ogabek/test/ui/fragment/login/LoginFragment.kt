package dev.ogabek.test.ui.fragment.login

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import dev.ogabek.test.R
import dev.ogabek.test.adapter.LoginPagerAdapter
import dev.ogabek.test.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        setTabItems()

        initViews()

        return binding.root
    }

    private fun setTabItems() {
        for (i in 0..1) {
            val tv: TextView = LayoutInflater.from(requireContext()).inflate(R.layout.t_login,null) as TextView
            if (i == 0) {
                tv.text = getString(R.string.login)
            } else {
                tv.text = getString(R.string.sign_up)
            }

            tv.typeface = Typeface.createFromAsset(context?.assets, "semi_bold.otf");
            binding.tlLoginSignup.getTabAt(i)!!.customView = tv;
        }
    }

    private fun initViews() {
        binding.apply {
            viewPager.adapter = LoginPagerAdapter(requireActivity())
            tlLoginSignup.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    viewPager.currentItem = tab!!.position
                }
                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })

            viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    tlLoginSignup.getTabAt(position)!!.select()
                }
            })
        }
    }

}