package com.vchornenkyi.appsaudit.di

import com.vchornenkyi.appsaudit.base.BaseApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        // Install the base Android module:
        AndroidSupportInjectionModule::class,
        MainModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication>