package com.vchornenkyi.appsaudit.feature.list.di

import com.vchornenkyi.appsaudit.feature.list.ListAppsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListAppsModule {

    @ContributesAndroidInjector
    abstract fun contributeListAppsFragment(): ListAppsFragment
}