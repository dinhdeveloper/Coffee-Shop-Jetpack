package com.example.jetpack.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpack.R
import com.example.jetpack.model.CategoryModel
import com.example.jetpack.ui.theme.bgMainWhile
import com.example.jetpack.utils.ShareViewModel
import com.example.jetpack.viewmodel.CategoryViewModel

@Preview(showBackground = true)
@Composable
fun HomePreview400() {
    HomeScreen(shareViewModel = ShareViewModel(), navController = rememberNavController())
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun HomePreview1000() {
    HomeScreen(shareViewModel = ShareViewModel(), navController = rememberNavController())
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun HomePreview700() {
    HomeScreen(shareViewModel = ShareViewModel(), navController = rememberNavController())
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(
    shareViewModel: ShareViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    var multiSelectValue = mutableStateOf<CategoryModel?>(null)

    val categoryViewModel: CategoryViewModel = hiltViewModel()
    categoryViewModel.getListCategory()
    val dataCategory = categoryViewModel.dataCategory

    if (dataCategory.size > 0) {
        multiSelectValue.value = dataCategory[0]
    }

    ConstraintLayout(
        modifier = modifier
    ) {
        val horizontalGuideline50 = createGuidelineFromTop(0.25f)
        val (
            imgIcon,
            toolbarHome,
            titleHome,
            listCategory,
            listProduct,
            titleToday,
            listToday,
            titlePopuler,
            listPopuler
        ) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.ic_bg_home_1),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(imgIcon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(horizontalGuideline50)
                }
                .fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .constrainAs(toolbarHome) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(end = 15.dp, top = 15.dp)
        ) {
            CustomToolbarHomeScreen()
        }

        Text(
            text = "Best Coffee in Town",
            color = bgMainWhile,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(start = 15.dp)
                .constrainAs(titleHome) {
                    top.linkTo(toolbarHome.bottom)
                    start.linkTo(parent.start)
                }
        )
        //list category
        Column(
            modifier = Modifier
                .padding(start = 5.dp, top = 10.dp)
                .constrainAs(listCategory) {
                    top.linkTo(titleHome.bottom)
                    start.linkTo(parent.start)
                }
        ) {
            CustomListCategory(dataCategory, onClick = {
                multiSelectValue.value = null
                multiSelectValue.value = it
            })
        }
        //list product
        Column(
            modifier = Modifier
                .padding(start = 5.dp, top = 10.dp)
                .constrainAs(listProduct) {
                    top.linkTo(listCategory.bottom)
                    start.linkTo(parent.start)
                }
        ) {
            CustomListProduct(shareViewModel, navController, multiSelectValue.value)
        }

        //list today
        Text(
            text = "Today's Deal",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.6f),
            modifier = Modifier
                .padding(top = 20.dp, start = 15.dp)
                .constrainAs(titleToday) {
                    top.linkTo(listProduct.bottom)
                    start.linkTo(parent.start)
                }
        )

        Column(
            modifier = Modifier
                .constrainAs(listToday) {
                    top.linkTo(titleToday.bottom)
                    start.linkTo(parent.start)
                }
        ) {
            CustomListTodayDeal()
        }

        //most popular
        Text(
            text = "Most Popular",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black.copy(alpha = 0.6f),
            modifier = Modifier
                .padding(top = 20.dp, start = 15.dp)
                .constrainAs(titlePopuler) {
                    top.linkTo(listToday.bottom)
                    start.linkTo(parent.start)
                }
        )

        Column(
            modifier = Modifier
                .constrainAs(listPopuler) {
                    top.linkTo(titlePopuler.bottom)
                    start.linkTo(parent.start)
                }
        ) {
            CustomListPopular()
        }
    }
}