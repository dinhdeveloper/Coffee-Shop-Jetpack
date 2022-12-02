package com.example.jetpack.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpack.R
import com.example.jetpack.ui.theme.bgGreen
import com.example.jetpack.ui.theme.bgProduct
import com.example.jetpack.ui.theme.bgToolbar
import com.example.jetpack.ui.theme.bgTransient


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreviewProduct() {
    CustomListProduct()
}

@Composable
fun CustomListProduct() {
    LazyRow {
        items(10) {
            ConstraintLayout(
                modifier = Modifier
                    .height(200.dp)
                    .width(160.dp)
                    .padding(horizontal = 10.dp)
                    .background(bgTransient)
            ) {
                val horizontalGuideline25 = createGuidelineFromTop(0.30f)
                val horizontalGuideline75 = createGuidelineFromTop(0.65f)
                val (itemProduct, imvProduct, textProduct, textPrice) = createRefs()
                ConstraintLayout(
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(bgProduct)
                        .constrainAs(itemProduct) {
                            top.linkTo(horizontalGuideline25)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    Text(
                        text = "100.000 VNĐ",
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic,
                        fontSize = 13.sp,
                        color = bgGreen,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .constrainAs(textPrice) {
                                start.linkTo(parent.start)
                                bottom.linkTo(parent.bottom)
                            }
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                    )

                    Text(
                        text = "PHIN Sữa Đá PHIN Sữa Đá PHIN Sữa Đá",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = Color.White,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .constrainAs(textProduct) {
                                start.linkTo(parent.start)
                                bottom.linkTo(textPrice.top)
                            }
                            .padding(horizontal = 10.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.image_3), contentDescription = null,
                    modifier = Modifier.constrainAs(imvProduct) {
                        bottom.linkTo(horizontalGuideline75)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
            }
        }
    }
}