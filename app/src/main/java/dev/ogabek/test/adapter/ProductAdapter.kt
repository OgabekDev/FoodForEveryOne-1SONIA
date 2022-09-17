package dev.ogabek.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.test.databinding.ItemProductBinding
import dev.ogabek.test.model.Meal

class ProductAdapter(private val meals: ArrayList<Meal>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    var onClick: ((Meal) -> Unit)? = null

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal) {
            binding.apply {
                ivImage.setImageResource(meal.mainImage)
                tvName.text = meal.name
                tvPrice.text = meal.price

                root.setOnClickListener {
                    onClick?.invoke(meal)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = meals.size

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bind(meals[position])
    }

}