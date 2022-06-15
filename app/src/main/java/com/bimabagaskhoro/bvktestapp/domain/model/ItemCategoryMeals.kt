package com.bimabagaskhoro.bvktestapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemCategoryMeals(
    @field:SerializedName("strCategory")
    val strCategory: String,

    @field:SerializedName("strCategoryDescription")
    val strCategoryDescription: String,

    @field:SerializedName("idCategory")
    val idCategory: String,

    @field:SerializedName("strCategoryThumb")
    val strCategoryThumb: String
) : Parcelable
