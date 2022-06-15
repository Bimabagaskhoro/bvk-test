package com.bimabagaskhoro.bvktestapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bimabagaskhoro.bvktestapp.R
import com.bimabagaskhoro.bvktestapp.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}