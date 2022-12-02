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
import com.example.jetpack.ui.theme.bgGreen


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreviewCategory() {
    CustomListCategory()
}

data class ItemData(val content: String)

@Composable
fun CustomListCategory() {
    val listA = listOf(
        ItemData("Angola"),
        ItemData("Bahrain"),
        ItemData("Afghanistan"),
        ItemData("Denmark"),
        ItemData("Egypt"),
        ItemData("El Salvador"),
        ItemData("Fiji"),
        ItemData("Japan"),
        ItemData("Kazakhstan"),
        ItemData("Kuwait"),
        ItemData("Laos"),
        ItemData("Mongolia")
    )

    var selectedItem by remember { mutableStateOf(listA[0]) }

    LazyRow {
        items(listA.size, itemContent = { surah ->
                SurahListItem(
                    itemData = listA[surah],
                    setSelected = selectedItem.let {
                        listA[surah].content == it.content
                    }
                ) {
                    selectedItem = it
                }
            }
        )
    }
}

@Composable
fun SurahListItem(
    itemData: ItemData,
    setSelected: Boolean,
    isSelected: (ItemData) -> Unit
) {

    val cardColor = if (setSelected) bgGreen else White
    Text(
        text = itemData.content.uppercase(),
        color = cardColor,
        fontFamily = FontFamily.Default,
        fontSize = 15.sp,
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable {
                (if (!setSelected) itemData else null)?.let { isSelected(it) }
            }
    )
}