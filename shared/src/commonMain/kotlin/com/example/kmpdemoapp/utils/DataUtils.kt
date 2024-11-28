package com.example.kmpdemoapp.utils

object DataUtils {

    fun getChineseZodiacYear(year: Int): String {
        val tianGan = listOf("甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸")
        val diZhi = listOf("子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥")
        val tianGanIndex = (year - 3) % 10
        val diZhiIndex = (year - 3) % 12
        return tianGan[tianGanIndex] + diZhi[diZhiIndex]
    }

    fun getData(){
    }

    fun getDataString():String{
        return "${getChineseZodiacYear(2024)}"
    }
}