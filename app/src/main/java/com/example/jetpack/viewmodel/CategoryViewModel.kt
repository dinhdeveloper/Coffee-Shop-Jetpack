package com.example.jetpack.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack.model.CategoryModel
import com.example.jetpack.repository.CategoryRepository
import com.example.jetpack.utils.DataResponse
import com.example.jetpack.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    val dataCategory: MutableList<CategoryModel> = mutableStateListOf()
    fun getListCategory() {
        if (dataCategory.isNotEmpty()) return
        viewModelScope.launch {
            categoryRepository.getListCategory().let { dataResponse ->
                dataResponse.let { dataCategory.addAll(it) }
            }
        }
    }
}