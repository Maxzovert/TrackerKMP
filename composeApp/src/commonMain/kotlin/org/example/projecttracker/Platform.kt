package org.example.projecttracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform