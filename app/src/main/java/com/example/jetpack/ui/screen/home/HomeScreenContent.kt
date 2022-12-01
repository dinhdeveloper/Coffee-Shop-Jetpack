package com.example.jetpack.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.jetpack.R
import com.example.jetpack.model.CategoryModel
import com.example.jetpack.navigation.Screen
import com.example.jetpack.utils.ShareViewModel

@Composable
fun HomeScreenContent(
    shareViewModel: ShareViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
    ) {
        val horizontalGuideline50 = createGuidelineFromTop(0.25f)
        val imgIcon = createRef()

        Image(
            painter = painterResource(id = R.drawable.ic_bg_home_1),
            contentDescription = null,
            modifier = Modifier.constrainAs(imgIcon) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(horizontalGuideline50)
            }
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.no_available_data),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.padding(50.dp))
        Button(
            onClick = {
                shareViewModel.addCategoryModel(categoryModel)
                navController.navigate(Screen.ProductDetailScreen.route)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.net_conn_err_title))
        }
    }
}
private val categoryModel = CategoryModel(1,"HEHE","HIHI",1)