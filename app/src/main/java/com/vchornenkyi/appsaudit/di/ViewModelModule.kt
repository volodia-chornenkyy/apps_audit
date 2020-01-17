package com.vchornenkyi.appsaudit.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vchornenkyi.appsaudit.feature.list.ListAppsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * https://github.com/android/architecture-components-samples/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/di/ViewModelModule.kt
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListAppsViewModel::class)
    abstract fun bindUserViewModel(userViewModel: ListAppsViewModel): ViewModel
}


