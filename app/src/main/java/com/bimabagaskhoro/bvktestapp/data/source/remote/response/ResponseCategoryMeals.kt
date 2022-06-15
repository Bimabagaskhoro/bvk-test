package com.bimabagaskhoro.bvktestapp.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseCategoryMeals(

	@field:SerializedName("categories")
	val categories: List<CategoriesItem>
) : Parcelable

@Parcelize
data class CategoriesItem(

	@field:SerializedName("strCategory")
	val strCategory: String,

	@field:SerializedName("strCategoryDescription")
	val strCategoryDescription: String,

	@field:SerializedName("idCategory")
	val idCategory: String,

	@field:SerializedName("strCategoryThumb")
	val strCategoryThumb: String
) : Parcelable
