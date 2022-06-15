package com.bimabagaskhoro.bvktestapp.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMeals(

    @field:SerializedName("meals")
    val meals: List<MealsItem>
) : Parcelable

@Parcelize
data class MealsItem(

    @field:SerializedName("strMealThumb")
    val strMealThumb: String,

    @field:SerializedName("idMeal")
    val idMeal: String,

    @field:SerializedName("strMeal")
    val strMeal: String
) : Parcelable
