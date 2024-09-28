package com.example.bubble.ui.home

data class AppInfo(
    val appIcon: Int,    // Resource ID for the app icon
    val appName: String,  // Name of the app
    val timeSpentString: String,  // Time spent (e.g., "1h 20m")
    val timeSpentInMinutes: Int   // Time spent in minutes (e.g., 80 minutes for "1h 20m")
)
