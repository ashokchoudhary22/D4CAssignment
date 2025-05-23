package com.d4c.assignment.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.d4c.assignment.R
import com.d4c.assignment.SampleProductCategories
import com.d4c.assignment.SampleProducts
import com.d4c.assignment.SamplePromoBannersDataList
import com.d4c.assignment.ui.components.ProductCard
import com.d4c.assignment.ui.components.ProductCategories
import com.d4c.assignment.ui.components.ProductsListHeader
import com.d4c.assignment.ui.components.PromoBannerCarousel
import com.d4c.assignment.ui.components.ShopTopBar

@Composable
fun ShopScreen(
    modifier: Modifier = Modifier
) {

    val ctx = LocalContext.current

    val notImplemented: () -> Unit = {
        Toast.makeText(ctx, ctx.getString(R.string.not_implemented_yet), Toast.LENGTH_SHORT).show()
    }

    Column(modifier = modifier.fillMaxHeight()) {
        ShopTopBar(3, 5, notImplemented, notImplemented, notImplemented, notImplemented)
        LazyColumn {
            item {
                Column() {
                    Spacer(Modifier.size(4.dp))
                    PromoBannerCarousel(SamplePromoBannersDataList)
                    Spacer(Modifier.size(20.dp))
                    ProductCategories(SampleProductCategories, notImplemented)
                    ProductsListHeader(notImplemented)
                }
            }

            items(SampleProducts.size){
                ProductCard(SampleProducts[it], notImplemented, notImplemented)
            }
        }

    }
}

@Composable
@Preview
fun PreviewShopScreen() {
    ShopScreen()
}
