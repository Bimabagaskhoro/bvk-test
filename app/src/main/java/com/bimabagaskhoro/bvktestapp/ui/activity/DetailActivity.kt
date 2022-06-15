package com.bimabagaskhoro.bvktestapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.bimabagaskhoro.bvktestapp.R
import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.databinding.ActivityDetailBinding
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.ui.viewmodel.MealsViewModel
import com.bumptech.glide.Glide
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

        val getId = intent.getParcelableExtra<ItemDetailMeals>(EXTRA_DATA_ID)
        //showDetailMeals(getId)
    }

//    private fun showDetailMeals(id: ItemDetailMeals?) {
//        id?.let {
//            val idMeal = id.idMeal
//            viewModel.getDetailMeals(idMeal).observe(this) {
//                when (it) {
//                    is Resource.Loading -> {
//                        binding.progressbar.visibility = View.VISIBLE
//                    }
//                    is Resource.Success -> {
//                        binding.apply {
//                            Glide.with(this@DetailActivity)
//                                .load(it.data?.idMeal)
//                                .apply(RequestOptions().override(55, 55))
//                                .into(imgMeals)
//                            tvTittleMeals.text = it.data?.strMeal
//                            tvDescMeals.text = it.data?.strCategory
//                        }
//                    }
//                    else-> {
//                        Log.d(TAG, "show detail meals error")
//                    }
//                }
//            }
//        }
//    }

    private fun initViewModel(id: Int) {

    }


    companion object {
        const val EXTRA_DATA_ID = "extra_data"
    }
}