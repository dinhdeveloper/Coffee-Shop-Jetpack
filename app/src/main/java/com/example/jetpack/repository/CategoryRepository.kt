package com.example.jetpack.repository

import com.example.jetpack.model.CategoryModel
import com.example.jetpack.repository.categoryImpl.CategoryServiceImpl
import com.example.jetpack.utils.DataResponse
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoryServices : CategoryServiceImpl){

    suspend fun getListCategory() : DataResponse<List<CategoryModel>>{
        return categoryServices.getListCategory()
    }
}