package com.bimabagaskhoro.bvktestapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.bvktestapp.R
import com.bimabagaskhoro.bvktestapp.databinding.ItemsCategoryMealsBinding
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bumptech.glide.Glide

@SuppressLint("NotifyDataSetChanged")
class CategoryMealsAdapter : RecyclerView.Adapter<CategoryMealsAdapter.ViewHolder>() {

    private var listData = ArrayList<ItemCategoryMeals>()
    var onItemClick: ((ItemCategoryMeals) -> Unit)? = null

    fun setData(newListData: List<ItemCategoryMeals>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.items_category_meals, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsCategoryMealsBinding.bind(itemView)
        fun bind(data: ItemCategoryMeals) {
            binding.apply {
                Glide.with(itemView.context)
                    .asBitmap()
                    .load(data.strCategoryThumb)
                    .into(imgMeals)
                tvTittleMeals.text = data.strCategory
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}