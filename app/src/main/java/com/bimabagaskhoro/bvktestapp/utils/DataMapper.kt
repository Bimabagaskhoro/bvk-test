package com.bimabagaskhoro.bvktestapp.utils

import com.bimabagaskhoro.bvktestapp.data.source.remote.response.CategoriesItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsDetailItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsItem
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemMeals
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object DataMapper {
    fun entitiesToDomainCategory(data: List<CategoriesItem>): List<ItemCategoryMeals> =
        data.map {
            ItemCategoryMeals(
                strCategory = it.strCategory,
                strCategoryDescription = it.strCategoryDescription,
                idCategory = it.idCategory,
                strCategoryThumb = it.strCategoryThumb
            )
        }

    fun domainToEntityCategory(data: ItemCategoryMeals): CategoriesItem =
        CategoriesItem(
            strCategory = data.strCategory,
            strCategoryDescription = data.strCategoryDescription,
            idCategory = data.idCategory,
            strCategoryThumb = data.strCategoryThumb
        )

    fun entityToDomainCategory(data: CategoriesItem): ItemCategoryMeals =
        ItemCategoryMeals(
            strCategory = data.strCategory,
            strCategoryDescription = data.strCategoryDescription,
            idCategory = data.idCategory,
            strCategoryThumb = data.strCategoryThumb
        )

    fun entitiesToDomainDetailItems(data: List<MealsDetailItem>): List<ItemDetailMeals> =
        data.map {
            ItemDetailMeals(
                strImageSource = it.strImageSource,
                strIngredient10 = it.strIngredient10,
                strIngredient12 = it.strIngredient12,
                strIngredient11 = it.strIngredient11,
                strIngredient14 = it.strIngredient14,
                strCategory = it.strCategory,
                strIngredient13 = it.strIngredient13,
                strIngredient16 = it.strIngredient16,
                strIngredient15 = it.strIngredient15,
                strIngredient18 = it.strIngredient18,
                strArea = it.strArea,
                strIngredient17 = it.strIngredient17,
                strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
                strIngredient19 = it.strIngredient19,
                strTags = it.strTags,
                idMeal = it.idMeal,
                strInstructions = it.strInstructions,
                strIngredient1 = it.strIngredient1,
                strIngredient3 = it.strIngredient3,
                strIngredient2 = it.strIngredient2,
                strIngredient20 = it.strIngredient20,
                strIngredient5 = it.strIngredient5,
                strIngredient4 = it.strIngredient4,
                strIngredient7 = it.strIngredient7,
                strIngredient6 = it.strIngredient6,
                strIngredient9 = it.strIngredient9,
                strIngredient8 = it.strIngredient8,
                strMealThumb = it.strMealThumb,
                strMeasure20 = it.strMeasure20,
                strYoutube = it.strYoutube,
                strMeal = it.strMeal,
                strMeasure12 = it.strMeasure12,
                strMeasure13 = it.strMeasure13,
                strMeasure10 = it.strMeasure10,
                strMeasure11 = it.strMeasure11,
                dateModified = it.dateModified,
                strDrinkAlternate = it.strDrinkAlternate,
                strSource = it.strSource,
                strMeasure9 = it.strMeasure9,
                strMeasure7 = it.strMeasure7,
                strMeasure8 = it.strMeasure8,
                strMeasure5 = it.strMeasure5,
                strMeasure6 = it.strMeasure6,
                strMeasure3 = it.strMeasure3,
                strMeasure4 = it.strMeasure4,
                strMeasure1 = it.strMeasure1,
                strMeasure18 = it.strMeasure18,
                strMeasure2 = it.strMeasure2,
                strMeasure19 = it.strMeasure19,
                strMeasure16 = it.strMeasure16,
                strMeasure17 = it.strMeasure17,
                strMeasure14 = it.strMeasure14,
                strMeasure15 = it.strMeasure15
            )
        }

    fun entityToDomainDetailItems(data: MealsDetailItem): ItemDetailMeals =
        ItemDetailMeals(
            strImageSource = data.strImageSource,
            strIngredient10 = data.strIngredient10,
            strIngredient12 = data.strIngredient12,
            strIngredient11 = data.strIngredient11,
            strIngredient14 = data.strIngredient14,
            strCategory = data.strCategory,
            strIngredient13 = data.strIngredient13,
            strIngredient16 = data.strIngredient16,
            strIngredient15 = data.strIngredient15,
            strIngredient18 = data.strIngredient18,
            strArea = data.strArea,
            strIngredient17 = data.strIngredient17,
            strCreativeCommonsConfirmed = data.strCreativeCommonsConfirmed,
            strIngredient19 = data.strIngredient19,
            strTags = data.strTags,
            idMeal = data.idMeal,
            strInstructions = data.strInstructions,
            strIngredient1 = data.strIngredient1,
            strIngredient3 = data.strIngredient3,
            strIngredient2 = data.strIngredient2,
            strIngredient20 = data.strIngredient20,
            strIngredient5 = data.strIngredient5,
            strIngredient4 = data.strIngredient4,
            strIngredient7 = data.strIngredient7,
            strIngredient6 = data.strIngredient6,
            strIngredient9 = data.strIngredient9,
            strIngredient8 = data.strIngredient8,
            strMealThumb = data.strMealThumb,
            strMeasure20 = data.strMeasure20,
            strYoutube = data.strYoutube,
            strMeal = data.strMeal,
            strMeasure12 = data.strMeasure12,
            strMeasure13 = data.strMeasure13,
            strMeasure10 = data.strMeasure10,
            strMeasure11 = data.strMeasure11,
            dateModified = data.dateModified,
            strDrinkAlternate = data.strDrinkAlternate,
            strSource = data.strSource,
            strMeasure9 = data.strMeasure9,
            strMeasure7 = data.strMeasure7,
            strMeasure8 = data.strMeasure8,
            strMeasure5 = data.strMeasure5,
            strMeasure6 = data.strMeasure6,
            strMeasure3 = data.strMeasure3,
            strMeasure4 = data.strMeasure4,
            strMeasure1 = data.strMeasure1,
            strMeasure18 = data.strMeasure18,
            strMeasure2 = data.strMeasure2,
            strMeasure19 = data.strMeasure19,
            strMeasure16 = data.strMeasure16,
            strMeasure17 = data.strMeasure17,
            strMeasure14 = data.strMeasure14,
            strMeasure15 = data.strMeasure15

        )


    fun entitiesToDomainMeals(data: List<MealsItem>): List<ItemMeals> =
        data.map {
            ItemMeals(
                strMealThumb = it.strMealThumb,
                idMeal = it.idMeal,
                strMeal = it.strMeal
            )
        }
}