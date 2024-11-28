package com.example.kmpdemoapp.android

//import net.sourceforge.chinese_calendar.ChineseCalendar
//import net.sourceforge.chinese_calendar.ChineseDate
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmpdemoapp.utils.DataUtils
import com.xhinliang.lunarcalendar.LunarCalendar


class MainActivity : ComponentActivity() {
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
}


fun getCurrentData():String{
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
    val lunarCalender = LunarCalendar.obtainCalendar(2024, 11, 26)
    return "${lunarCalender.lunar} +${DataUtils.getChineseZodiacYear(2024)} "
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
