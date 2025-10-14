package com.m3tech.kmmcounter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform