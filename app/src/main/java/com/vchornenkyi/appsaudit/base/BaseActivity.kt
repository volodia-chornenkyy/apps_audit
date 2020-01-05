package com.vchornenkyi.appsaudit.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vchornenkyi.appsaudit.di.AndroidSafeInjection

abstract class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSafeInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}