package com.vchornenkyi.appsaudit.feature.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.vchornenkyi.appsaudit.domain.applisting.AndroidApp
import com.vchornenkyi.appsaudit.domain.applisting.AppsListingProvider
import com.vchornenkyi.appsaudit.test.ViewModelCoroutineRule
import com.vchornenkyi.appsaudit.test.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
class ListAppsViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val viewModelCoroutineRule = ViewModelCoroutineRule()

    @Mock
    lateinit var observer: Observer<List<AndroidApp>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `Get list if the available apps`() = runBlocking {
        val mock = mock(AppsListingProvider::class.java)
        val listOfAppInfo = listOf(
            generateApplicationInfo("test1"),
            generateApplicationInfo("test2")
        )
        whenever(mock.getApps()).thenReturn(listOfAppInfo)
        val viewModel = ListAppsViewModel(mock)

        viewModel.installedAppsData.observeForever(observer)

        verify(observer).onChanged(listOfAppInfo)
    }

    private fun generateApplicationInfo(packageName: String): AndroidApp {
        return AndroidApp(packageName, packageName)
    }
}