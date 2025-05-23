package com.d4c.assignment.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val ColorSchema = lightColorScheme(
    background = GreyBg,
)

@Composable
fun D4CAssignmentTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = ColorSchema,
        typography = Typography,
        content = content
    )
}