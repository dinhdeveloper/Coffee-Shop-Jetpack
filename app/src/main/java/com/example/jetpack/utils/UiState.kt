package com.example.jetpack.utils

sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    object Success : UiState()
    class Error(val error: String?) : UiState()
}