package com.example.kmpdemoapp.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kmpdemoapp.android.utils.DateHelper
import com.example.kmpdemoapp.android.widget.PalaceView
import com.example.kmpdemoapp.model.Palace


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingView(Greeting().greet())
                    GreetingView(getCurrentData())
                }
            }
        }
    }

    @Composable
    fun GreetingView(text: String) {
        val curData = viewModel.curData
        var desc by remember {
            mutableStateOf(DateHelper.getNongLiDetail())
        }
        Column {
            Button(onClick = {
                desc = DateHelper.getNongLiDetail()
//                Log.d("qw", "${DateHelper.getBureauNumb()}")
////            Log.d("qw", "${DateHelper.getBureauNumb(LocalDateTime.of(2022,4,28,20,44))}")
//                val data = curData.sortedBy {
//                    it.number
//                }
//                Log.d("qw", "$data")
                viewModel.updatePalaceContentFromNumber(9)
            }) {
                Text("刷新")
            }
            Text(text = DateHelper.getNongLiDateString())
            Box(modifier = Modifier.border(1.dp, Color.Gray)) {
                LazyVerticalGrid(GridCells.Fixed(3)) {
                    itemsIndexed(curData) { index: Int, item: Palace ->
                        PalaceView(item)
                    }
                }
            }
        }
    }
}


fun getCurrentData(): String {
    // 获取当前日期时间
//    val currentDate = LocalDate.now(ZoneId.systemDefault())
//
//    // 将当前日期转换为农历日期
//    val locale: Locale = Locale("fr")
//    Calende
//    val chineseCalendar = ChineseCalendar(SIMPLIFIED_CHINESE)
//    chineseCalendar.
//    chineseCalendar.get
//    chineseCalendar.s
//    val chineseDate = chineseCalendar.getChineseDate()

//    val date = "20241121"
//    return NongLi.getDate(date)
//    val lunarCalender = LunarCalendar.obtainCalendar(2024, 11, 26)
    return "农历 ${DateHelper.getNongLiDateString()}"
}


//@Preview
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        GreetingView("Hello, Android!")
//    }
//}
