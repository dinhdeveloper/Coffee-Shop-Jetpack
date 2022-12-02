package com.example.jetpack.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpack.R
import com.example.jetpack.ui.theme.*


@Preview(showBackground = true)
@Composable
fun HomePreviewTodayDeal() {
    CustomListTodayDeal()
}


@Composable
fun CustomListTodayDeal() {
    LazyRow {
        items(10) {
            Column {
                Card(
                    shape = RoundedCornerShape(7.dp),
                    elevation = 5.dp,
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .height(140.dp)
                        .padding(15.dp)
                ) {
                    Row {
                        Column(
                            Modifier.width(150.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.tra_sua),
                                contentDescription = null,
                                Modifier
                                    .fillParentMaxHeight()
                                    .clip(RoundedCornerShape(7)),
                                contentScale = ContentScale.FillHeight
                            )
                        }
                        //text
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(2f)
                                .fillParentMaxHeight()
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "PHIN Sữa Đá PHIN Sữa Đá PHIN Sữa Đá",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = Color.Black,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = "100.000 VNĐ",
                                fontWeight = FontWeight.Light,
                                fontStyle = FontStyle.Italic,
                                fontSize = 13.sp,
                                color = Color.Black,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textDecoration = TextDecoration.LineThrough,
                                modifier = Modifier.padding(vertical = 10.dp)
                            )

                            Text(
                                text = "29.000 VNĐ",
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                color = Color.Black,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        //button add

                        Column(
                            Modifier.padding(top = 40.dp, end = 15.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                                    .border(
                                        1.dp,
                                        bgProduct,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_plus_bg),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}