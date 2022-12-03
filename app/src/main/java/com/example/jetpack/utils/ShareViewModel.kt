package com.example.jetpack.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.jetpack.model.CategoryModel
import com.example.jetpack.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ShareViewModel @Inject constructor(): ViewModel() {

    var categoryState by mutableStateOf<CategoryModel?>(null)
        private set

    fun addCategoryModel(newCategory : CategoryModel){
        categoryState = newCategory
    }

    var productSate by mutableStateOf<(ProductModel?)>(null)
        private set

    fun addProductModel(newProduct : ProductModel){
        productSate = newProduct
    }
}