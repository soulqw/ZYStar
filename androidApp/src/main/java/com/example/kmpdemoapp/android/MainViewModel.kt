package com.example.kmpdemoapp.android

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kmpdemoapp.utils.DataUtils

class MainViewModel : ViewModel() {

    val curData by lazy {
        DataUtils.obtainNineAcquiredPalace()
    }

    fun updatePalaceContentFromNumber(number: Int) {
        val originPositionData = curData.sortedBy {
            it.number
        }
        val liuyi = DataUtils.sanqiliuyi
        if (number > 0) {
            var index = number - 1
            liuyi.forEach {
                Log.d("qw","set $index and ${originPositionData[index].name} and $it")
                originPositionData[index].tianPanGan = it
                index++
                if (index > 8) {
                    index -= 9
                }
            }
        } else {

        }
        Log.d("qw","数据$originPositionData")

    }

}