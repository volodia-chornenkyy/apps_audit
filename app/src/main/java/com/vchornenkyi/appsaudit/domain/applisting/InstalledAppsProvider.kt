package com.vchornenkyi.appsaudit.domain.applisting

import android.content.Context
import android.content.pm.PackageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InstalledAppsProvider @Inject constructor(private val context: Context) :
    AppsListingProvider {

    private val packageManager: PackageManager = context.packageManager

    override suspend fun getApps(): List<AndroidApp> = withContext(Dispatchers.Default) {
        val packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        return@withContext packages
            .map { applicationInfo ->
                AndroidApp(
                    applicationInfo.packageName,
                    packageManager.getApplicationLabel(applicationInfo).toString()
                )
            }
    }
}