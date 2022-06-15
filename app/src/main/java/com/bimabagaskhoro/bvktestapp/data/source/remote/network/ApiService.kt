package com.bimabagaskhoro.bvktestapp.data.source.remote.network

import com.bimabagaskhoro.bvktestapp.data.source.remote.response.ResponseCategoryMeals
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.ResponseDetailMeals
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.ResponseMeals
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    suspend fun getMealsCategory(): ResponseCategoryMeals

    @GET("filter.php?")
    suspend fun getFilterByCategory(
        @Query("c") category: String,
    ): ResponseMeals

    @GET("lookup.php")
    suspend fun getDetailMeals(
        @Query("i") id: Int,
    ): ResponseDetailMeals

    @GET("search.php")
    suspend fun getSearchByName(
        @Query("s") name: String,
    ): ResponseDetailMeals
}