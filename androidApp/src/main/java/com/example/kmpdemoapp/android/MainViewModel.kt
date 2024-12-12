package com.example.kmpdemoapp.android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kmpdemoapp.utils.DataUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _showResult = MutableLiveData(MainState(false))

    val showResult: LiveData<MainState>
        get() = _showResult

    val curData by lazy {
        DataUtils.obtainNineAcquiredPalace()
    }

    private val _isViewVisibleFlow = MutableStateFlow(false)

    val isViewVisibleFlow: StateFlow<Boolean> = _isViewVisibleFlow.asStateFlow()

    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    fun setViewVisible(visible: Boolean) {
        _isViewVisibleFlow.value = visible
    }

    fun updatePalaceContentFromNumber(number: Int) {
        val originPositionData = curData.sortedBy {
            it.number
        }
        val liuyi = DataUtils.sanqiliuyi
        if (number > 0) {
            var index = number - 1
            var jigongName = ""
            liuyi.forEachIndexed { _, it ->
                Log.d("qw", "set $index and ${originPositionData[index].name} and $it")
                val currentPlace = originPositionData[index]
                if (currentPlace.number == 5) {
                    jigongName = it
                } else {
                    originPositionData[index].diPanGan = it
                }
                index++
                if (index > 8) {
                    index -= 9
                }
            }
            originPositionData[1].diPanGan += jigongName
        } else {

        }
        setViewVisible(true)
        Log.d("qw", "数据$originPositionData")
    }

}