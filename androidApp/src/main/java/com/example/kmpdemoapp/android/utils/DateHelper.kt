package com.example.kmpdemoapp.android.utils

import android.util.Log
import com.example.kmpdemoapp.utils.DataUtils
import com.xhinliang.lunarcalendar.LunarCalendar
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

object DateHelper {

    /**
     * https://zhuanlan.zhihu.com/p/675536607
     */
    fun getBureauNumb(
        dataTime: LocalDateTime = LocalDateTime.now()
    ): Int {
        val year = dataTime.year
        val month = dataTime.month
        val day = dataTime.dayOfMonth
        val hour = dataTime.hour
        val minute = dataTime.minute
        val nongli = LunarCalendar.obtainCalendar(year, month.value, day)
        val nongliYearArray = DataUtils.getChineseZodiacYear(nongli.year)
        //甲辰年 取辰地支参数
        val yearName = nongliYearArray[1]
        val yearNumb = DataUtils.dizhiMap[yearName]
        val monthNumb = nongli.lunar.month
        val dayNumb = nongli.lunar.day
        val timeNumb = DataUtils.dizhiMap[DataUtils.getChineseTime(
            hour,
            minute
        )]
        val finalNumb = (yearNumb!! + monthNumb + dayNumb + timeNumb!!) % 9
        Log.d(
            "qw",
            "yearName${yearName} yearValue$yearNumb monthNumb$monthNumb dayNumb$dayNumb timeNumb${
                DataUtils.getChineseTime(
                    hour,
                    minute
                )
            }"
        )
        if (finalNumb == 0) {
            return 9
        }
        return finalNumb
    }

    fun getNongLiDateString(): String {
        val currentDateTime = LocalDate.now()
        val year = currentDateTime.year
        val month = currentDateTime.month
        val day = currentDateTime.dayOfMonth
        val currentTime = LocalTime.now()
        val hour = currentTime.hour
        val minute = currentTime.minute
        val second = currentTime.second
        val nongli = LunarCalendar.obtainCalendar(year, month.value, day)
        return "${nongli.year}年 ${nongli.lunar.month}月 ${nongli.day}日 ${hour}时 ${minute} 分 ${second} 秒"
    }

    fun getNongLiDetail(
        data: LocalDate = LocalDate.now(),
        dataTime: LocalDateTime = LocalDateTime.now()
    ): String {
        val year = data.year
        val month = data.month
        val day = data.dayOfMonth
        val hour = dataTime.hour
        val minute = dataTime.minute
        val nongli = LunarCalendar.obtainCalendar(year, month.value, day)
        return "${DataUtils.getChineseZodiacYearString(nongli.year)}年 ${
            DataUtils.getChineseTime(
                hour,
                minute
            )
        }"
    }

}