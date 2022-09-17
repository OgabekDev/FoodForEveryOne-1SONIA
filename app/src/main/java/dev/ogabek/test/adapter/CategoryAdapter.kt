package dev.ogabek.test.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.test.databinding.ItemCategoryBinding
import dev.ogabek.test.model.Category

class CategoryAdapter(private var categories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var onClick: (() -> Unit)? = null

    private var checkedPosition = 0

    inner class ViewHolder(private val binding: ItemCategoryBinding ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.tvName.text = category.name
            if (category.isSelected) {
                binding.vSelected.visibility = View.VISIBLE
                binding.tvName.setTextColor(Color.parseColor("#FA4A0C"))
            } else {
                binding.vSelected.visibility = View.INVISIBLE
                binding.tvName.setTextColor(Color.parseColor("#9A9A9D"))
            }

            binding.root.setOnClickListener {
                categories[checkedPosition].isSelected = false
                notifyItemChanged(checkedPosition)

                checkedPosition = adapterPosition

                categories[checkedPosition].isSelected = true
                notifyItemChanged(checkedPosition)

                onClick?.invoke()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        return ViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

}