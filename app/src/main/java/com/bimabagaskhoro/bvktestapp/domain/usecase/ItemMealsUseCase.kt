package com.bimabagaskhoro.bvktestapp.domain.usecase

import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemMeals
import kotlinx.coroutines.flow.Flow

interface ItemMealsUseCase {
    fun getMealsCategory(): Flow<Resource<List<ItemCategoryMeals>>>

    fun getFilterByCategory(c: String): Flow<Resource<List<ItemMeals>>>

    fun getDetailMeals(id: String): Flow<Resource<ItemDetailMeals>>

    fun getSearchByName(name: String): Flow<Resource<List<ItemMeals>>>
}