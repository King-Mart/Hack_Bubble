package com.example.bubble.apps

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class App(
    @StringRes val stringResourceId: Int,
//    @DrawableRes val iconResourceId: Int,
    @IntegerRes val timeSpentId: Int
)