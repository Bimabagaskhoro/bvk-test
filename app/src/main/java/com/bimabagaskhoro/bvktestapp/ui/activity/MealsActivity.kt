package com.bimabagaskhoro.bvktestapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.databinding.ActivityMealsBinding
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bimabagaskhoro.bvktestapp.ui.adapter.CategoryMealsAdapter
import com.bimabagaskhoro.bvktestapp.ui.adapter.MealsAdapter
import com.bimabagaskhoro.bvktestapp.ui.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMealsBinding
    private val viewModel: MealsViewModel by viewModels()
    private lateinit var adapter: MealsAdapter
    private val TAG = MealsActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MealsAdapter()
        adapter.onItemClick = { meals ->
            Intent(this, DetailActivity::class.java).also {
                it.putExtra(DetailActivity.EXTRA_DATA_ID, meals)
                startActivity(it)
            }
        }
        binding.floatingActionButton.setOnClickListener {
            intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        val getNameCategory = intent.getParcelableExtra<ItemCategoryMeals>(EXTRA_DATA)
        showDetailCategory(getNameCategory)
    }

    private fun showDetailCategory(nameCategory: ItemCategoryMeals?) {
        nameCategory?.let {
            val name = nameCategory.strCategory
            viewModel.getFilterByCategory(name).observe(this) {
                when (it) {
                    is Resource.Loading -> {
                        binding.progressbar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        adapter.setData(it.data!!)
                        binding.apply {
                            progressbar.visibility = View.GONE
                            rvMeals.adapter = adapter
                            rvMeals.layoutManager = GridLayoutManager(this@MealsActivity, 2)
                            rvMeals.setHasFixedSize(true)
                        }
                    }
                    else -> {
                        Log.d(TAG, "show detail category error")
                    }
                }
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}