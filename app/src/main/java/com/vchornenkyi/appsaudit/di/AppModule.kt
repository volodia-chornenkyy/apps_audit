package com.vchornenkyi.appsaudit.di

import android.content.Context
import com.vchornenkyi.appsaudit.base.BaseApplication
import com.vchornenkyi.appsaudit.domain.applisting.AppsListingProvider
import com.vchornenkyi.appsaudit.domain.applisting.InstalledAppsProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
abstract class AppModule {

    @Binds
    abstract fun bindContext(app: BaseApplication): Context

    @Binds
    @Singleton
    abstract fun bindAppListingProvider(provider: InstalledAppsProvider): AppsListingProvider
}