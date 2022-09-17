package dev.ogabek.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.LayoutParams
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.test.databinding.ItemProductBinding
import dev.ogabek.test.model.Meal

class SearchAdapter(private val meals: ArrayList<Meal>): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    var onClick: ((Meal) -> Unit)? = null

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal) {
            binding.apply {
                ivImage.setImageResource(meal.mainImage)
                tvName.text = meal.name
                tvPrice.text = meal.price

                if (adapterPosition == 1) {
                    binding.v2.visibility = View.VISIBLE
                } else {
                    binding.v2.visibility = View.GONE
                }

                root.setOnClickListener {
                    onClick?.invoke(meal)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        return ViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = meals.size

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        holder.bind(meals[position])
    }

}