package com.bimabagaskhoro.bvktestapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemMeals(
    @field:SerializedName("strMealThumb")
    val strMealThumb: String,

    @field:SerializedName("idMeal")
    val idMeal: String,

    @field:SerializedName("strMeal")
    val strMeal: String
) : Parcelable
