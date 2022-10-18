package com.douglastaquary.kmm.firebasekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform