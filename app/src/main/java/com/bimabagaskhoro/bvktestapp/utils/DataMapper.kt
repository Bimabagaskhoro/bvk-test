package com.bimabagaskhoro.bvktestapp.utils

import com.bimabagaskhoro.bvktestapp.data.source.remote.response.CategoriesItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsDetailItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsItem
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemMeals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object DataMapper {

    fun entitiesToDomainCategory(dataResponse: List<CategoriesItem?>?): Flow<List<ItemCategoryMeals>> {
        val listCategory = ArrayList<ItemCategoryMeals>()
        dataResponse?.map {
            ItemCategoryMeals(
                it?.strCategory,
                it?.strCategoryDescription,
                it?.idCategory,
                it?.strCategoryThumb
            ).let { data ->
                listCategory.add(data)
            }
        }
        return flowOf(listCategory)
    }

    fun entitiesToDomainMeals(dataResponse: List<MealsItem?>?): Flow<List<ItemMeals>> {
        val listMeals = ArrayList<ItemMeals>()
        dataResponse?.map {
            ItemMeals(
                it?.strMealThumb,
                it?.idMeal,
                it?.strMeal
            ).let { data ->
                listMeals.add(data)
            }
        }
        return flowOf(listMeals)
    }

    fun entitiesToDomainDetail(dataResponse: MealsDetailItem?): Flow<ItemDetailMeals> {
        return flowOf(
            ItemDetailMeals(
                dataResponse?.strImageSource,
                dataResponse?.strIngredient10,
                dataResponse?.strIngredient12,
                dataResponse?.strIngredient11,
                dataResponse?.strIngredient14,
                dataResponse?.strIngredient13,
                dataResponse?.strIngredient16,
                dataResponse?.strIngredient15,
                dataResponse?.strIngredient18,
                dataResponse?.strArea,
                dataResponse?.strIngredient17,
                dataResponse?.strTags,
                dataResponse?.idMeal,
                dataResponse?.strInstructions,
                dataResponse?.strIngredient1,
                dataResponse?.strIngredient3,
                dataResponse?.strIngredient2,
                dataResponse?.strIngredient20,
                dataResponse?.strIngredient13,
                dataResponse?.strIngredient4,
                dataResponse?.strIngredient7,
                dataResponse?.strIngredient6,
                dataResponse?.strIngredient9,
                dataResponse?.strIngredient8,
                dataResponse?.strMealThumb,
                dataResponse?.strMeasure20,
                dataResponse?.strYoutube,
                dataResponse?.strMeal,
                dataResponse?.strMeasure12,
                dataResponse?.strMeasure13,
                dataResponse?.strMeasure10,
                dataResponse?.strMeasure11,
                dataResponse?.strSource,
                dataResponse?.strMeasure9,
                dataResponse?.strMeasure7,
                dataResponse?.strMeasure8,
                dataResponse?.strMeasure5,
                dataResponse?.strMeasure6,
                dataResponse?.strMeasure3,
                dataResponse?.strMeasure4,
                dataResponse?.strMeasure1,
                dataResponse?.strMeasure18,
                dataResponse?.strMeasure2,
                dataResponse?.strMealThumb,
                dataResponse?.strMeasure19,
                dataResponse?.strMeasure16,
                dataResponse?.strMeasure17,
                dataResponse?.strMeasure14,
                dataResponse?.strMeasure15,

            )
        )
    }
}