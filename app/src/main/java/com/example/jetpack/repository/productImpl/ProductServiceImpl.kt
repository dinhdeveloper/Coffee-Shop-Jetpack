package com.example.jetpack.repository.productImpl

import android.content.Context
import com.example.jetpack.model.ProductModel
import com.example.jetpack.utils.LoadDataFromJsonFile
import javax.inject.Inject

class ProductServiceImpl @Inject constructor(private val context: Context) {
    fun getListProduct(): List<ProductModel> {
        return LoadDataFromJsonFile.readFileToProductModel(context)
    }

    fun getListProductByCategory(id: Int): List<ProductModel> {
        return LoadDataFromJsonFile.readFileToProductModelByCategory(context, id)
    }


}