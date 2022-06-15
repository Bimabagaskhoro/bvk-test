package com.bimabagaskhoro.bvktestapp.di

import com.bimabagaskhoro.bvktestapp.domain.usecase.ItemMealsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideItemMealsUseCase(itemMealsUseCase: ItemMealsUseCase): ItemMealsUseCase
}