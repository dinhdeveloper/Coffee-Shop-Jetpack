package com.example.jetpack.ui.screen.product_detail

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.jetpack.R
import com.example.jetpack.utils.ShareViewModel

@Composable
fun ProductDetailScreen(
    shareViewModel: ShareViewModel
) {
    var productModel = shareViewModel.productSate
    LaunchedEffect(key1 = productModel){
        if (productModel != null){
            Log.e("SSSSSSSSSSSSS","${productModel.productName}")
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = stringResource(id = R.string.unknown_err_title))
    }
}