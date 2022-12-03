package com.example.jetpack.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack.model.ProductModel
import com.example.jetpack.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    val dataProduct: MutableList<ProductModel> = mutableStateListOf()
    fun getListProduct() {
        if (dataProduct.isNotEmpty()) return
        viewModelScope.launch {
            productRepository.getListProduct().let { dataResponse ->
                dataResponse.let { dataProduct.addAll(it) }
            }
        }
    }

    val dataProductByCategory: MutableList<ProductModel> = mutableStateListOf()
    fun getListProductByCategory(id: Int) {
        if (dataProduct.isNotEmpty()) return
        viewModelScope.launch {
            productRepository.getListProductByCategory(id).let { dataResponse ->
                dataProductByCategory.clear()
                dataResponse.let { dataProductByCategory.addAll(it) }
            }
        }
    }


}