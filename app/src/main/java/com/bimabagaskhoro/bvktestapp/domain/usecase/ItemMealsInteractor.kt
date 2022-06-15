package com.bimabagaskhoro.bvktestapp.domain.usecase

import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemMeals
import com.bimabagaskhoro.bvktestapp.domain.repository.IItemMealsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemMealsInteractor @Inject constructor(private val itemMealsRepository: IItemMealsRepository) :
    ItemMealsUseCase {
    override fun getMealsCategory(): Flow<Resource<List<ItemCategoryMeals>>> =
        itemMealsRepository.getMealsCategory()

    override fun getFilterByCategory(c: String): Flow<Resource<List<ItemMeals>>> =
        itemMealsRepository.getFilterByCategory(c)

    override fun getDetailMeals(id: String): Flow<Resource<ItemDetailMeals>> =
        itemMealsRepository.getDetailMeals(id)

    override fun getSearchByName(name: String): Flow<Resource<List<ItemMeals>>> =
        itemMealsRepository.getSearchByName(name)
}