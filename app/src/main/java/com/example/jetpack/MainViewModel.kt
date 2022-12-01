package com.example.jetpack

import android.content.Context
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import com.example.jetpack.utils.APP_LANGUAGE
import com.example.jetpack.utils.dataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * A View model with hiltViewModel annotation that is used to access this view model everywhere needed
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    val currentLanguage = context.dataStore.data.map {
        it[APP_LANGUAGE] ?: "en"
    }
}

val LocalMainViewModel =
    compositionLocalOf<MainViewModel> { error("Main view model is not provided!") }