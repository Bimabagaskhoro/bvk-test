package com.bimabagaskhoro.bvktestapp.data.source.remote

import android.util.Log
import com.bimabagaskhoro.bvktestapp.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.bvktestapp.data.source.remote.network.ApiService
import com.bimabagaskhoro.bvktestapp.data.source.remote.response.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getMealsCategory() = flow {
        try {
            val response = apiService.getMealsCategory().categories
            if (response != null) {
                if (response.isNotEmpty()) {
                    emit(StatusResponseOnline.Success(response))
                } else {
                    emit(StatusResponseOnline.Error("Data kosong"))
                }
            }

        } catch (e: Exception) {
            emit(StatusResponseOnline.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getFilterByCategory(category: String) = flow {
        try {
            val response = apiService.getFilterByCategory(category).meals
            if (response!!.isNotEmpty()) {
                emit(StatusResponseOnline.Success(response))
            } else {
                emit(StatusResponseOnline.Error("Data kosong"))
            }

        } catch (e: Exception) {
            emit(StatusResponseOnline.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getDetailMeals(id: String) = flow {
        try {
            val response = apiService.getDetailMeals(id).detailMeals
            emit(StatusResponseOnline.Success(response))
        } catch (e: Exception) {
            emit(StatusResponseOnline.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getSearchByName(name: String) = flow {
        try {
            val response = apiService.getSearchByName(name).meals
            if (response!!.isNotEmpty()) {
                emit(StatusResponseOnline.Success(response))
            } else {
                emit(StatusResponseOnline.Error("Data kosong"))
            }

        } catch (e: Exception) {
            emit(StatusResponseOnline.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

}