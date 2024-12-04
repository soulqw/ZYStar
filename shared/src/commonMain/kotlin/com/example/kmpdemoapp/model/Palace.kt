package com.example.kmpdemoapp.model

data class Palace(val number: Int, val name: String) {

    var isEmpty = false

    var tianPanGan = ""

    var diPanGan = ""

    fun getElement(): FiveElement {
        return when (number) {
            6, 7 -> FiveElement.GOLD
            2, 5, 8 -> FiveElement.EARTH
            1 -> FiveElement.WATER
            9 -> FiveElement.FIRE
            3, 4 -> FiveElement.WOOD
            else -> FiveElement.GOLD
        }
    }

}
