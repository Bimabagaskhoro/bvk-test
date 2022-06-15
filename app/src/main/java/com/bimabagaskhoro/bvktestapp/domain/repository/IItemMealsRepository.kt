package com.bimabagaskhoro.bvktestapp.domain.repository

import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemMeals
import kotlinx.coroutines.flow.Flow

interface IItemMealsRepository {
    fun getMealsCategory(): Flow<Resource<List<ItemCategoryMeals>>>

    fun getFilterByCategory(c: String): Flow<Resource<List<ItemMeals>>>

    fun getDetailMeals(id: Int): Flow<Resource<List<ItemDetailMeals>>>

    fun getSearchByName(name: String): Flow<Resource<List<ItemDetailMeals>>>
}