package com.vchornenkyi.appsaudit.di

import com.vchornenkyi.appsaudit.base.BaseApplication
import com.vchornenkyi.appsaudit.feature.list.di.ListAppsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ListAppsModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: BaseApplication): AppComponent
    }
}