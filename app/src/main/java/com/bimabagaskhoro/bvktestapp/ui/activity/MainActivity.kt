package com.bimabagaskhoro.bvktestapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.data.source.remote.RemoteDataSource
import com.bimabagaskhoro.bvktestapp.databinding.ActivityMainBinding
import com.bimabagaskhoro.bvktestapp.ui.adapter.CategoryMealsAdapter
import com.bimabagaskhoro.bvktestapp.ui.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MealsViewModel by viewModels()
    private lateinit var adapter: CategoryMealsAdapter

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        adapter = CategoryMealsAdapter()
        adapter.onItemClick = { meals ->
            Intent(this, MealsActivity::class.java).also {
                it.putExtra(MealsActivity.EXTRA_DATA, meals)
                startActivity(it)
            }
        }
    }

    private fun initViewModel() {
        viewModel.getMealsCategory().observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.setData(it.data!!)
                    binding.apply {
                        progressbar.visibility = View.GONE
                        rvMeals.adapter = adapter
                        rvMeals.layoutManager = GridLayoutManager(this@MainActivity, 2)
                        rvMeals.setHasFixedSize(true)
                    }
                }
                else -> {
                    Log.d(TAG, "initViewModel main activity error")
                }
            }
        }
    }
}