package com.bimabagaskhoro.bvktestapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.bimabagaskhoro.bvktestapp.R
import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.databinding.ActivityDetailBinding
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemMeals
import com.bimabagaskhoro.bvktestapp.ui.viewmodel.MealsViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: MealsViewModel by viewModels()
    private val TAG = DetailActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getParcelableExtra<ItemMeals>(EXTRA_DATA_ID)
        showDetailMeals(id)
    }

    private fun showDetailMeals(id: ItemMeals?) {
        id?.let {
            val idMeal = id.idMeal
            viewModel.getDetailMeals(idMeal.toString()).observe(this) {
                when (it) {
                    is Resource.Loading -> {
                        binding.progressbar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        fetchDataMeals(it.data)
                    }
                    else -> {
                        Log.d(TAG, "show detail meals error")
                    }
                }
            }
        }
    }

    private fun fetchDataMeals(data: ItemDetailMeals?) {
        if (data != null){
            binding.apply {
                tvTittleMeals.text = data.strMeal
                tvDescMeals.text = data.strInstructions
                Glide.with(this@DetailActivity)
                    .load(data.strMealThumb)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_launcher_background)
                    )
                    .into(imgMeals)
            }
        }
    }

    companion object {
        const val EXTRA_DATA_ID = "extra_data"
    }
}