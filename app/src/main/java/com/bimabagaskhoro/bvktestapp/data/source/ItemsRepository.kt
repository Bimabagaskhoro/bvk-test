package com.bimabagaskhoro.bvktestapp.data.source

import android.content.ContentValues.TAG
import android.util.Log
import com.bimabagaskhoro.bvktestapp.data.Resource
import com.bimabagaskhoro.bvktestapp.data.source.remote.RemoteDataSource
import com.bimabagaskhoro.bvktestapp.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsDetailItem
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
        return flow {
            when (val apiResponse = remoteDataSource.getMealsCategory().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.entitiesToDomainCategory(apiResponse.data!!)))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getMealsCategory: Empty Data")
                }
            }
        }
    }

    override fun getFilterByCategory(c: String): Flow<Resource<List<ItemMeals>>> {
        return flow {
            when (val apiResponse = remoteDataSource.getFilterByCategory(c).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.entitiesToDomainMeals(apiResponse.data!!)))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getFilterByCategory: Empty Data")
                }
            }
        }
    }

    override fun getDetailMeals(id: String): Flow<Resource<MealsDetailItem>> {
        return flow {
            when (val apiResponse = remoteDataSource.getDetailMeals(id).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(apiResponse.data!!))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getDetailMeals: Empty Data")
                }
            }
        }
    }

    override fun getSearchByName(name: String): Flow<Resource<List<ItemMeals>>> {
        return flow {
            when (val apiResponse = remoteDataSource.getSearchByName(name).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.entitiesToDomainMeals(apiResponse.data!!)))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getSearchByName: Empty Data")
                }
            }
        }
    }
}