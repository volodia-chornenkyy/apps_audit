package com.vchornenkyi.appsaudit.domain.applisting

import android.content.Context
import android.content.pm.PackageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InstalledAppsProvider @Inject constructor(private val context: Context) :
    AppsListingProvider {

    override suspend fun getApps(): List<AndroidApp> = withContext(Dispatchers.Default) {
        val pm: PackageManager = context.packageManager
        val packages = pm.getInstalledApplications(PackageManager.GET_META_DATA)
        return@withContext packages
            .map { packageInfo ->
                AndroidApp(
                    packageInfo.packageName,
                    packageInfo.name
                )
            }
    }
}