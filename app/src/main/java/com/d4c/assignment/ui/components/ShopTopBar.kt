package com.d4c.assignment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d4c.assignment.R
import com.d4c.assignment.ui.theme.FontTangerine
import com.d4c.assignment.ui.theme.GreenPrimary

@Composable
fun ShopTopBar(
    favoriteCount: Int,
    cartCount: Int,
    onBackButtonClick: () -> Unit,
    onSearchClick: () -> Unit,
    onWishListClick: () -> Unit,
    onCartClick: () -> Unit

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onBackButtonClick,
                modifier = Modifier.size(28.dp)) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = stringResource(R.string.shop), color = Color.White, fontSize = 28.sp, fontFamily = FontTangerine
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onSearchClick, modifier =
            Modifier.size(38.dp)) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            IconWithBadge(
                icon = Icons.Default.FavoriteBorder,
                badgeCount = favoriteCount,
                onWishListClick
            )

            IconWithBadge(
                icon = Icons.Default.ShoppingCart,
                badgeCount = cartCount,
                onCartClick
            )
        }
    }
}

@Composable
fun IconWithBadge(icon: ImageVector, badgeCount: Int, onClick: () -> Unit) {
    Box(
    ) {
        IconButton(onClick, modifier = Modifier.size(38.dp)) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
        if (badgeCount > 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = (2).dp, y = (2).dp)
                    .size(18.dp)
                    .background(GreenPrimary, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badgeCount.toString(),
                    color = Color.Black,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewShopTopBar() {
    ShopTopBar(5, 3, {}, {}, {}, {})
}
