package dev.ogabek.test.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.ogabek.test.R
import dev.ogabek.test.adapter.CategoryAdapter
import dev.ogabek.test.adapter.ProductAdapter
import dev.ogabek.test.databinding.FragmentHomeBinding
import dev.ogabek.test.model.Category
import dev.ogabek.test.model.Meal

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setCategories()
        setProduct()

        initViews()

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        binding.bottomNav.menu.getItem(0).isChecked = true
    }

    private fun setCategories() {

        val categories = ArrayList<Category>().apply {
            add(Category(0, "Foods", true))
            add(Category(1, "Drinks", false))
            add(Category(2, "Snacks", false))
            add(Category(3, "Sauce", false))
            add(Category(4, "Milk", false))
        }

        val adapter = CategoryAdapter(categories)

        adapter.onClick = {
            setProduct()
        }

        binding.rvCategory.adapter = adapter


    }

    private fun setProduct() {
        val products = ArrayList<Meal>().apply {
            for (i in 0..4) {
                add(Meal(i, getString(R.string.veggie_ntomato_mix), getString(R.string.n1_900), getString(R.string.delivery_info), getString(R.string.return_policy), R.drawable.meal, arrayListOf(R.drawable.meal, R.drawable.meal, R.drawable.meal, R.drawable.meal)))
            }
        }

        val adapter = ProductAdapter(products)

        adapter.onClick = {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)

            findNavController().navigate(action)
        }

        binding.rvMeals.adapter = adapter

    }

    private fun initViews() {

        binding.apply {
            llSearch.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
            }
            btnCart.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
            }
        }

        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.user -> {
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_home -> {
                    findNavController()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.love -> {
                    findNavController()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.history -> {
                    findNavController()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        binding.bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

}