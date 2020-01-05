package com.vchornenkyi.appsaudit.di

import com.vchornenkyi.appsaudit.feature.list.ListAppsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun contributeListAppsFragment(): ListAppsFragment
}