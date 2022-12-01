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

    val onlineCategoryUiState = mutableStateOf<UiState>(UiState.Loading)
    val onlineCategory: MutableList<CategoryModel> = mutableStateListOf()

    init {
        getListCategory()
    }

    private fun getListCategory() {
        if (onlineCategory.isNotEmpty()) return
        viewModelScope.launch {
            categoryRepository.getListCategory().let { dataResponse ->
                when (dataResponse) {
                    is DataResponse.Loading -> {
                        onlineCategoryUiState.value = UiState.Loading
                    }
                    is DataResponse.Success -> {
                        /** Got a response from the server successfully */
                        onlineCategoryUiState.value = UiState.Success
                        dataResponse.data?.let { onlineCategory.addAll(it) }
                        //dataResponse()?.let { onlineCategory.addAll(it) }
                    }
                    is DataResponse.Error -> {
                        /** An error happened when fetching data from the server */
                        onlineCategoryUiState.value =
                            UiState.Error(error = dataResponse.message)
                    }
                }
            }
        }
    }
}