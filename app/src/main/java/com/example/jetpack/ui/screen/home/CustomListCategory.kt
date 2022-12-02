package com.example.jetpack.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.ui.theme.bgToolbar


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreviewCategory() {
    CustomListCategory()
}

@Composable
fun CustomListCategory() {
    LazyRow {
        items(10) {
            Text(
                text = "Cà phê pha phin".uppercase(),
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
        }
    }
}