package com.example.jetpack.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.jetpack.model.CategoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ShareViewModel @Inject constructor(): ViewModel() {

    var categoryState by mutableStateOf<CategoryModel?>(null)
        private set

    fun addCategoryModel(newCategory : CategoryModel){
        categoryState = newCategory
    }
}