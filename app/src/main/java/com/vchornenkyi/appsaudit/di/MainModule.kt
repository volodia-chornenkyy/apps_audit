package com.vchornenkyi.appsaudit.di

import com.vchornenkyi.appsaudit.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}