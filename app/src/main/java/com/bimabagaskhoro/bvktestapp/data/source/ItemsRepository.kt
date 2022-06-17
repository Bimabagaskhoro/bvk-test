package com.bimabagaskhoro.bvktestapp.data.source

import android.content.ContentValues.TAG
import android.util.Log
import com.bimabagaskhoro.bvktestapp.data.NetworkOnlyResource
import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.data.source.remote.RemoteDataSource
import com.bimabagaskhoro.bvktestapp.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.CategoriesItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsDetailItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.StatusResponseOnline
import com.bimabagaskhoro.bvktestapp.domain.model.ItemCategoryMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemMeals
import com.bimabagaskhoro.bvktestapp.domain.repository.IItemMealsRepository
import com.bimabagaskhoro.bvktestapp.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IItemMealsRepository {
    override fun getMealsCategory(): Flow<Resource<List<ItemCategoryMeals>>> {
        return object : NetworkOnlyResource<List<ItemCategoryMeals>, List<CategoriesItem?>>() {
            override fun loadFromNetwork(data: List<CategoriesItem?>): Flow<List<ItemCategoryMeals>> =
                DataMapper.entitiesToDomainCategory(data)

            override suspend fun createCall(): Flow<StatusResponseOnline<List<CategoriesItem?>>> =
                remoteDataSource.getMealsCategory()
        }.asFlow()

    }

    override fun getFilterByCategory(c: String): Flow<Resource<List<ItemMeals>>> {
        return object : NetworkOnlyResource<List<ItemMeals>, List<MealsItem?>>() {
            override fun loadFromNetwork(data: List<MealsItem?>): Flow<List<ItemMeals>> =
                DataMapper.entitiesToDomainMeals(data)

            override suspend fun createCall(): Flow<StatusResponseOnline<List<MealsItem?>>> =
                remoteDataSource.getFilterByCategory(c)
        }.asFlow()
    }

    override fun getSearchByName(name: String): Flow<Resource<List<ItemMeals>>> {
        return object : NetworkOnlyResource<List<ItemMeals>, List<MealsItem?>>() {
            override fun loadFromNetwork(data: List<MealsItem?>): Flow<List<ItemMeals>> =
                DataMapper.entitiesToDomainMeals(data)

            override suspend fun createCall(): Flow<StatusResponseOnline<List<MealsItem?>>> =
                remoteDataSource.getSearchByName(name)
        }.asFlow()
    }

    override fun getDetailMeals(id: String): Flow<Resource<ItemDetailMeals>> {
        return object : NetworkOnlyResource<ItemDetailMeals, MealsDetailItem?>() {
            override fun loadFromNetwork(data: MealsDetailItem?): Flow<ItemDetailMeals> {
                return DataMapper.entitiesToDomainDetail(data)
            }

            override suspend fun createCall(): Flow<StatusResponseOnline<MealsDetailItem?>> {
                return remoteDataSource.getDetailMeals(id)
            }

        }.asFlow()
    }
}