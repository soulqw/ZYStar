package com.example.kmpdemoapp

import com.example.kmpdemoapp.utils.DataUtils
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String =
        DataUtils.getDataString()
}

actual fun getPlatform(): Platform = IOSPlatform()