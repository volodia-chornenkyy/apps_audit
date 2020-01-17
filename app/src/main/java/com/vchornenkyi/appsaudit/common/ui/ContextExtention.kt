package com.vchornenkyi.appsaudit.common.ui

import android.content.Context
import android.util.DisplayMetrics
import androidx.annotation.DimenRes

fun Context.dpToPx(dp: Int): Int {
    return (dp * (resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
}

fun Context.px(@DimenRes resId: Int): Int {
    return resources.getDimensionPixelOffset(resId)
}