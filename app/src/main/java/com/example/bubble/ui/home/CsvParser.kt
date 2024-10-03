package com.example.bubble.ui.home

import com.example.bubble.R
import java.io.InputStream

class CsvParser {
    fun parseTimeToSeconds(timeString: String): Int {
        // Split the time string by ":" (hours:minutes:seconds)
        val parts = timeString.split(":")

        // Convert hours, minutes, and seconds to integers
        val hours = parts[0].toInt()    // First part is hours
        val minutes = parts[1].toInt()  // Second part is minutes
        val seconds = parts[2].toInt()  // Third part is seconds

        // Convert the entire time to seconds
        return (hours * 3600) + (minutes * 60) + seconds
    }
    fun convertSecondsToTimeString(totalSeconds: Int): String {
        val hours = totalSeconds / 3600        // Calculate the number of hours
        val minutes = (totalSeconds % 3600) / 60  // Calculate the number of minutes (remainder of hours / 60)
        val seconds = totalSeconds % 60        // Remaining seconds after calculating hours and minutes

        // Return the formatted time string as "xxhxxmxxs"
        return String.format("%02dh%02dm%02ds", hours, minutes, seconds)

    }
    fun timeHMS(time : String):String{
        return convertSecondsToTimeString(parseTimeToSeconds(time))
    }
    private fun readCsv(inputStream: InputStream): List<AppInfo> {
        val reader = inputStream.bufferedReader()
        val header = reader.readLine()
        print(reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val (app, timeSpent, gibberish) = it.split(',', ignoreCase = false, limit = 3)
                AppInfo(R.drawable.ic_launcher_foreground, app.trim(), timeHMS(timeSpent), parseTimeToSeconds(timeSpent))
            }.toList() )
        return reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val (app, timeSpent, gibberish) = it.split(',', ignoreCase = false, limit = 3)
                AppInfo(R.drawable.ic_launcher_foreground, app.trim(), timeHMS(timeSpent), parseTimeToSeconds(timeSpent))
            }.toList()
    }



}