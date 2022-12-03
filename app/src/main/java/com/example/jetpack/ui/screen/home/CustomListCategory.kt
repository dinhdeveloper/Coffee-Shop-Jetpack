package com.example.jetpack.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.model.CategoryModel
import com.example.jetpack.ui.theme.bgGreen


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreviewCategory() {
}

@Composable
fun CustomListCategory(
    dataCategory: MutableList<CategoryModel>,
    onClick: (CategoryModel) -> Unit
) {

    var selectedItem by remember { mutableStateOf(dataCategory[0]) }

    LazyRow {
        items(dataCategory.size, itemContent = { surah ->
            SurahListItem(
                itemData = dataCategory[surah],
                setSelected = selectedItem.let {
                    dataCategory[surah].categoryId == it.categoryId
                }, {
                    selectedItem = it
                }
            ) {
                onClick(it)
            }
        }
        )
    }
}

@Composable
fun SurahListItem(
    itemData: CategoryModel,
    setSelected: Boolean,
    isSelected: (CategoryModel) -> Unit,
    onClick: (CategoryModel) -> Unit
) {

    val cardColor = if (setSelected) bgGreen else White
    itemData.categoryName?.let {
        Text(
            text = it.uppercase(),
            color = cardColor,
            fontFamily = FontFamily.Default,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .clickable {
                    (if (!setSelected) itemData else null)?.let { it -> isSelected(it) }
                    onClick(itemData)
                }
        )
    }
}