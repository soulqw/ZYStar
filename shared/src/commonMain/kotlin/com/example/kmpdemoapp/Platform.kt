package com.example.kmpdemoapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform