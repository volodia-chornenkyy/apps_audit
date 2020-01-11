package com.vchornenkyi.appsaudit

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun `Main activity launched`() {
        val scenario = launchActivity<MainActivity>()

        assertTrue(scenario.state == Lifecycle.State.RESUMED)
    }
}