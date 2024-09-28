package com.example.bubble.data
import com.example.bubble.R
import com.example.bubble.apps.App

class Datasource() {
    fun loadApps(): List<App> {
        return listOf<App>(
            App(R.string.app1, R.integer.timeSpent1))

    }
}