package com.d4c.assignment.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d4c.assignment.R
import com.d4c.assignment.models.PromoBannerData
import com.d4c.assignment.promoBannerDummyDataList
import com.d4c.assignment.ui.theme.D4CAssignmentTheme
import com.d4c.assignment.ui.theme.GreenPrimary

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun PromoBannerCarousel(
    modifier: Modifier = Modifier,
    banners: List<PromoBannerData>,
) {
    val pagerState = rememberPagerState(pageCount = { banners.size })

    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 50.dp)
        ) {
            repeat(banners.size) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(28.dp, 9.dp)
                        .background(
                            color = if (isSelected) GreenPrimary else Color.Black,
                            shape = RoundedCornerShape(50)
                        )
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) { page ->
            PromoBannerCard(
                data = banners[page]
            )
        }
    }
}

@Composable
fun PromoBannerCard(
    data: PromoBannerData
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color.Transparent)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_promotional_banner),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .padding(top = 40.dp, start = 40.dp)
                .align(Alignment.TopStart)
        ) {
            Text(
                text = data.title,
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = data.subtitle,
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = data.dateRange,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .background(GreenPrimary, shape = RoundedCornerShape(50))
                    .padding(horizontal = 6.dp, vertical = 0.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    D4CAssignmentTheme {
        PromoBannerCarousel(banners = promoBannerDummyDataList)
    }
}