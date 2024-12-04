package com.example.kmpdemoapp.utils

import com.example.kmpdemoapp.model.Palace

object DataUtils {

    val dizhiMap: Map<String, Int> = mapOf(
        "子" to 1,
        "丑" to 2,
        "寅" to 3,
        "卯" to 4,
        "辰" to 5,
        "巳" to 6,
        "午" to 7,
        "未" to 8,
        "申" to 9,
        "酉" to 10,
        "戌" to 11,
        "亥" to 12
    )

    val sanqiliuyi: List<String> = listOf(
        "戊", "己", "庚", "辛", "壬", "癸", "丁", "丙", "乙"
    )

    fun obtainNineAcquiredPalace(): List<Palace> = listOf(
        Palace(4, "巽"),
        Palace(9, "离"),
        Palace(2, "坤"),
        Palace(3, "震"),
        Palace(5, ""),
        Palace(7, "兑"),
        Palace(8, "艮"),
        Palace(1, "坎"),
        Palace(6, "乾"),
    )

    fun getChineseZodiacYear(year: Int): Array<String> {
        val tianGan = listOf("甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸")
        val diZhi = listOf("子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥")
        var tianGanIndex = (year - 3) % 10 - 1
        if (tianGanIndex < 0) {
            tianGanIndex += 10
        }
        var diZhiIndex = (year - 3) % 12 - 1
        if (diZhiIndex < 0) {
            diZhiIndex += 12
        }
        return arrayOf(tianGan[tianGanIndex], diZhi[diZhiIndex])
    }

    fun getChineseZodiacYearString(year: Int): String {
        val array = getChineseZodiacYear(year)
        return array[0] + array[1]
    }

    fun getChineseTime(hour: Int, minute: Int): String {
        val timeInHours = hour + (minute / 60.0)
        return when (timeInHours) {
            in 23.0..1.0 -> "子"
            in 1.0..3.0 -> "丑"
            in 3.0..5.0 -> "寅"
            in 5.0..7.0 -> "卯"
            in 7.0..9.0 -> "辰"
            in 9.0..11.0 -> "巳"
            in 11.0..13.0 -> "午"
            in 13.0..15.0 -> "未"
            in 15.0..17.0 -> "申"
            in 17.0..19.0 -> "酉"
            in 19.0..21.0 -> "戌"
            else -> "亥"
        }
    }

    fun getDataString(): String {
        return "${getChineseZodiacYearString(2024)}"
    }
}