package com.d4c.assignment.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d4c.assignment.R
import com.d4c.assignment.SampleProduct
import com.d4c.assignment.models.Product
import com.d4c.assignment.ui.theme.FontTangerine
import com.d4c.assignment.ui.theme.GreenPrimary
import com.d4c.assignment.ui.theme.Purple

@Composable
fun ProductCard(product: Product, onWhishlistClick: () -> Unit, onCartClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_product),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Black, shape = CircleShape)
                        .clickable { onWhishlistClick() },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = if(product.isWishlisted) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Purple,
                        modifier = Modifier.size(28.dp),
                    )
                }

                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 34.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                if (product.bestSeller) {
                    Text(
                        stringResource(R.string.best_seller),
                        color = GreenPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .background(Color.Black, RoundedCornerShape(20.dp))
                            .align(Alignment.TopEnd)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Box {
                Image(
                    painter = painterResource(id = R.drawable.bg_product_details),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )

                IconButton(
                    onClick = { onCartClick() },
                    modifier = Modifier
                        .padding(10.dp)
                        .size(52.dp)
                        .align(Alignment.BottomEnd)

                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp) // total size of the ring
                            .border(
                                width = 1.dp,
                                color = GreenPrimary,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_cart_green),
                            contentDescription = null,
                            tint = GreenPrimary,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 16.dp, top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.dot_divider),
                        color = if (product.inStock) GreenPrimary else Color.Red,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = if (product.inStock) stringResource(R.string.in_stock) else stringResource(
                            R.string.out_of_stock
                        ),
                        color = if (product.inStock) GreenPrimary else Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }

                Box {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            product.title,
                            color = GreenPrimary,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontTangerine
                        )
                        Spacer(Modifier.size(4.dp))
                        Text(
                            product.description,
                            color = Color.LightGray,
                            fontSize = 14.sp
                        )

                        Row (verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(2.dp)){
                            Text(
                                product.skinType,
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = stringResource(R.string.dot_divider),
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                product.skinType,
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }


                        Spacer(modifier = Modifier.height(18.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "RS. " + product.price,
                                color = Purple,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "RS. " + product.originalPrice,
                                color = Color.Gray,
                                fontSize = 14.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                        }

                        Spacer(modifier = Modifier.height(2.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Row() {
                                repeat(product.rating.toInt()) {
                                    Icon(
                                        Icons.Default.Star,
                                        contentDescription = null,
                                        tint = Color.Yellow,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                            Spacer(Modifier.size(4.dp))
                            Text(
                                "${product.reviews} reviews",
                                color = Color.White,
                                fontSize = 14.sp,
                                textDecoration = TextDecoration.Underline,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2A2A2A)
@Composable
fun PreviewProductCard() {
    ProductCard(SampleProduct, {}, {})
}