package com.example.kmpdemoapp.android.widget

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun LittleText(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier, fontSize = 14.sp)
}

@Composable
fun MiddleText(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier, fontSize = 18.sp)
}

@Composable
fun LargeText(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier, fontSize = 22.sp)
}