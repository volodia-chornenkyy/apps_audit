package com.vchornenkyi.appsaudit.feature.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vchornenkyi.appsaudit.domain.applisting.AndroidApp
import com.vchornenkyi.appsaudit.domain.applisting.AppsListingProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListAppsViewModel @Inject constructor(private val appsProvider: AppsListingProvider) :
    ViewModel() {

    val installedAppsData: LiveData<List<AndroidApp>> by lazy {
        val mutableLiveData = MutableLiveData<List<AndroidApp>>()
        viewModelScope.launch {
            mutableLiveData.value = appsProvider.getApps()
        }
        return@lazy mutableLiveData
    }
}