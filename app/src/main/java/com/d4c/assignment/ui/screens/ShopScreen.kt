package com.d4c.assignment.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.d4c.assignment.R
import com.d4c.assignment.promoBannerDummyDataList
import com.d4c.assignment.ui.components.PromoBannerCarousel
import com.d4c.assignment.ui.components.ShopTopBar

@Composable
fun ShopScreen(
    modifier: Modifier = Modifier
){

    val ctx = LocalContext.current

    val notImplemented: () -> Unit = {
        Toast.makeText(ctx, ctx.getString(R.string.not_implemented_yet), Toast.LENGTH_SHORT).show()
    }

    Column(modifier = modifier) {
        ShopTopBar(3,5, notImplemented, notImplemented, notImplemented, notImplemented)
        Spacer(Modifier.size(4.dp))
        PromoBannerCarousel(promoBannerDummyDataList)
    }
}

@Composable
@Preview
fun PreviewShopScreen(){
    ShopScreen()
}
