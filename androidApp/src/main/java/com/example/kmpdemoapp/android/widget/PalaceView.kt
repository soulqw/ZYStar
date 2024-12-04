package com.example.kmpdemoapp.android.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kmpdemoapp.model.Palace

@Composable
fun PalaceView(model: Palace) {
    Box(
        modifier = Modifier
            .border(
                0.5.dp, Color.Gray
            )
            .padding(4.dp)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                LittleText("八神", Modifier.align(Alignment.TopStart))
                LittleText("空亡", Modifier.align(Alignment.TopEnd))
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                LittleText(model.tianPanGan, Modifier.align(Alignment.TopStart))
                LittleText("九星", Modifier.align(Alignment.TopEnd))
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                LittleText("地盘干", Modifier.align(Alignment.TopStart))
                LittleText("八门", Modifier.align(Alignment.TopEnd))
            }
        }
//        LargeText(
//            text = "${model.name}${model.number}宫", modifier = Modifier.align(Alignment.Center)
//        )
    }
//     Column {
//        Text(text = model.name)
}