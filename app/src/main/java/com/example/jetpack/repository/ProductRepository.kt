package com.example.jetpack.repository

import com.example.jetpack.model.ProductModel
import com.example.jetpack.repository.productImpl.ProductServiceImpl
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productServices : ProductServiceImpl){

    fun getListProduct() : List<ProductModel>{
        return productServices.getListProduct()
    }

    fun getListProductByCategory(id: Int) : List<ProductModel>{
        return productServices.getListProductByCategory(id)
    }


}