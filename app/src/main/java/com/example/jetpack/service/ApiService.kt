package com.example.jetpack.service

import com.example.jetpack.model.CategoryModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("category/list")
    suspend fun getListCategory(): Response<List<CategoryModel>>
}