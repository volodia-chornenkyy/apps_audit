package com.vchornenkyi.appsaudit.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.vchornenkyi.appsaudit.di.AndroidSafeInjection

abstract class BaseFragment(@LayoutRes private val layoutResId: Int): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AndroidSafeInjection.inject(this)
        return inflater.inflate(layoutResId, container, false)
    }
}