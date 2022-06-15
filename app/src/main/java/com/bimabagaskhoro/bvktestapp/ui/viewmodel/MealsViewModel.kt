package com.bimabagaskhoro.bvktestapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bimabagaskhoro.bvktestapp.domain.usecase.ItemMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(val useCases: ItemMealsUseCase) : ViewModel() {
    fun getMealsCategory() = useCases.getMealsCategory().asLiveData()

    fun getFilterByCategory(c: String) = useCases.getFilterByCategory(c).asLiveData()

    fun getDetailMeals(id: Int) = useCases.getDetailMeals(id).asLiveData()

    fun getSearchByName(name: String) = useCases.getSearchByName(name).asLiveData()
}