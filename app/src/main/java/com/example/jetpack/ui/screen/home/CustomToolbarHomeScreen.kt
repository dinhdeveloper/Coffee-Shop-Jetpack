package com.example.jetpack.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.R
import com.example.jetpack.ui.theme.bgToolbar


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreviewToolbar() {
    CustomToolbarHomeScreen()
}

@Composable
fun CustomToolbarHomeScreen() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_search_while),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 10.dp)
                .width(30.dp)
                .height(30.dp)
                .padding(5.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_shopping_bag),
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .padding(5.dp)
        )
    }
}