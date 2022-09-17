package dev.ogabek.test.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.ogabek.test.R
import dev.ogabek.test.adapter.ProductAdapter
import dev.ogabek.test.adapter.SearchAdapter
import dev.ogabek.test.databinding.FragmentSearchBinding
import dev.ogabek.test.model.Meal

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        initViews()
        setProduct()

        return binding.root
    }

    private fun initViews() {
        binding.apply {
            icBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun setProduct() {
        val products = ArrayList<Meal>().apply {
            for (i in 0..5) {
                add(Meal(i, getString(R.string.veggie_ntomato_mix), getString(R.string.n1_900), getString(R.string.delivery_info), getString(R.string.return_policy), R.drawable.meal, arrayListOf(R.drawable.meal, R.drawable.meal, R.drawable.meal, R.drawable.meal)))
            }
        }

        val adapter = SearchAdapter(products)

        adapter.onClick = {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(it)

            findNavController().navigate(action)
        }

        binding.rvSearch.adapter = adapter

    }

}