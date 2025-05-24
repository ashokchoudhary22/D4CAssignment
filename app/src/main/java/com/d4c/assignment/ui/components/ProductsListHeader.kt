package com.d4c.assignment.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d4c.assignment.R
import com.d4c.assignment.ui.theme.FontTangerine

@Composable
fun ProductsListHeader(onSeeAllClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            stringResource(R.string.new_products),
            color = Color.White,
            fontSize = 22.sp,
            fontFamily = FontTangerine
        )
        Text(stringResource(R.string.see_all),
            color = Color.White,
            fontSize = 14.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { onSeeAllClick() }
            )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2A2A2A)
@Composable
fun PreviewProductsList() {
    ProductsListHeader({})
}