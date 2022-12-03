package com.example.jetpack.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class CategoryModel(
    val categoryId: Int = 0,
    val categoryName: String? = ""
)