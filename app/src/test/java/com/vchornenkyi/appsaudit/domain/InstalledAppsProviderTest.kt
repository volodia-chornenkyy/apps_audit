package com.vchornenkyi.appsaudit.domain

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.GET_META_DATA
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.vchornenkyi.appsaudit.domain.applisting.InstalledAppsProvider
import com.vchornenkyi.appsaudit.test.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy

@RunWith(AndroidJUnit4::class)
class InstalledAppsProviderTest {

    @Test
    fun `Get list of installed apps from PackageManager`() = runBlocking {
        val listOfAppInfo = listOf(
            generateApplicationInfo("test1"),
            generateApplicationInfo("test2")
        )
        checkInstalledApps(listOfAppInfo)
    }

    fun `No installed apps from PackageManager`() = runBlocking {
        checkInstalledApps(emptyList())
    }

    private suspend fun checkInstalledApps(listOfAppInfo: List<ApplicationInfo>) {
        val mock = mock(PackageManager::class.java)
        whenever(mock.getInstalledApplications(GET_META_DATA)).thenReturn(listOfAppInfo)
        val spyContext = spy(InstrumentationRegistry.getInstrumentation().context)
        whenever(spyContext.packageManager).thenReturn(mock)
        val installedAppsProvider =
            InstalledAppsProvider(
                spyContext
            )

        val apps = installedAppsProvider.getApps()

        assertTrue(
            "Received list of apps is different from the original",
            apps.none { androidApp ->
                val presentInExpectedList = listOfAppInfo.find { info ->
                    info.packageName == androidApp.packageName
                } == null
                presentInExpectedList
            }
        )
    }

    private fun generateApplicationInfo(packageName: String): ApplicationInfo {
        val mockAppInfo = mock(ApplicationInfo::class.java)
        mockAppInfo.packageName = packageName
        mockAppInfo.name = packageName
        return mockAppInfo
    }
}