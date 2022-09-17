package dev.ogabek.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.test.databinding.ItemCartBinding
import dev.ogabek.test.databinding.ItemProductBinding
import dev.ogabek.test.model.Meal

class CartAdapter(private val meals: ArrayList<Meal>): RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    lateinit var onDeleteClick: (() -> Unit)
    lateinit var onLikeClick: (() -> Unit)

    inner class ViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal) {
            binding.apply {
                ivImage.setImageResource(meal.mainImage)
                tvName.text = meal.name
                tvPrice.text = meal.price

                binding.tvMinus.setOnClickListener {
                    var quantity = binding.tvQuantity.text.toString().toInt()
                    if (quantity > 1) {
                        quantity--
                    }
                    binding.tvQuantity.text = quantity.toString()
                }

                binding.tvPlus.setOnClickListener {
                    val quantity = binding.tvQuantity.text.toString().toInt() + 1
                    binding.tvQuantity.text = quantity.toString()
                }

                binding.icDelete.setOnClickListener {
                    onDeleteClick.invoke()
                }

                binding.icLove.setOnClickListener {
                    onLikeClick.invoke()
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ViewHolder {
        return ViewHolder(ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = meals.size

    override fun onBindViewHolder(holder: CartAdapter.ViewHolder, position: Int) {
        holder.bind(meals[position])
    }

}