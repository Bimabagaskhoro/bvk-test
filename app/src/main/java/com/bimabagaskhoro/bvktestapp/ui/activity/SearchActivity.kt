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
import com.bimabagaskhoro.bvktestapp.databinding.ActivitySearchBinding
import com.bimabagaskhoro.bvktestapp.ui.adapter.MealsAdapter
import com.bimabagaskhoro.bvktestapp.ui.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val viewModel: MealsViewModel by viewModels()
    private lateinit var adapter: MealsAdapter
    private val TAG = SearchActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MealsAdapter()
        adapter.onItemClick = { meals ->
            Intent(this, DetailActivity::class.java).also {
                it.putExtra(DetailActivity.EXTRA_DATA_ID, meals)
                startActivity(it)
            }
        }

        binding.apply {
            edtSearch.setOnKeyListener { _, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    searchMeals()
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }
        }
    }

    private fun searchMeals() {
        binding.apply {
            val search = edtSearch.text.toString()
            if (search.isEmpty()) return
            initViewModel(search)
        }
    }

    private fun initViewModel(search: String) {
        viewModel.getSearchByName(search).observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.setData(it.data!!)
                    binding.apply {
                        progressbar.visibility = View.GONE
                        rvMeals.adapter = adapter
                        rvMeals.layoutManager = GridLayoutManager(this@SearchActivity, 2)
                        rvMeals.setHasFixedSize(true)
                    }
                }
                else -> {
                    Log.d(TAG, "search meal error")
                }
            }
        }
    }
}