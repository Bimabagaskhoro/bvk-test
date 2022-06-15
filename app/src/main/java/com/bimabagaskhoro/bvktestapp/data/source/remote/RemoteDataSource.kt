package com.bimabagaskhoro.bvktestapp.data.source.remote

import android.util.Log
import com.bimabagaskhoro.bvktestapp.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.bvktestapp.data.source.remote.network.ApiService
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.CategoriesItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsDetailItem
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.MealsItem
import com.bimabagaskhoro.bvktestapp.domain.model.ItemDetailMeals
import com.bimabagaskhoro.bvktestapp.domain.model.ItemMeals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    private val TAG = RemoteDataSource::class.java.simpleName

    suspend fun getMealsCategory(): Flow<ApiResponse<List<CategoriesItem>>> {
        return flow {
            try {
                val response = apiService.getMealsCategory()
                val data = response.categories
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getMealsCategory: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getFilterByCategory(category: String): Flow<ApiResponse<List<MealsItem>>> {
        return flow {
            try {
                val response = apiService.getFilterByCategory(category)
                val data = response.meals
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getFilterByCategory: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailMeals(id: String): Flow<ApiResponse<MealsDetailItem>> {
        return flow {
            try {
                val response = apiService.getDetailMeals(id)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getDetailMeals: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getSearchByName(name: String): Flow<ApiResponse<List<MealsItem>>> {
        return flow {
            try {
                val response = apiService.getSearchByName(name)
                val data = response.meals
                if (data.isNotEmpty()){
                    emit(ApiResponse.Success(data))
                }else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getSearchByName: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }
}