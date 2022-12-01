package com.example.jetpack.repository.categoryImpl

import com.example.jetpack.model.CategoryModel
import com.example.jetpack.service.ApiService
import com.example.jetpack.utils.BaseResponse
import com.example.jetpack.utils.DataResponse
import javax.inject.Inject

class CategoryServiceImpl @Inject constructor(private val apiService : ApiService) : BaseResponse() {

    suspend fun getListCategory(): DataResponse<List<CategoryModel>>{
       return safeApiCall {
           apiService.getListCategory()
       }
    }
}