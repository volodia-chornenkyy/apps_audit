package com.vchornenkyi.appsaudit.common.ui

import android.content.Context
import android.util.DisplayMetrics

fun Context.dpToPx(dp: Int): Int {
    return (dp * (resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
}