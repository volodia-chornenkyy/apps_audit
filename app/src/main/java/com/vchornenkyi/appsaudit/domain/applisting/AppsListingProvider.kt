package com.vchornenkyi.appsaudit.domain.applisting

interface AppsListingProvider {
    suspend fun getApps(): List<AndroidApp>
}



