package com.bimabagaskhoro.bvktestapp.di

import com.bimabagaskhoro.bvktestapp.data.source.ItemsRepository
import com.bimabagaskhoro.bvktestapp.domain.repository.IItemMealsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(itemMealsRepository: ItemsRepository): IItemMealsRepository
}