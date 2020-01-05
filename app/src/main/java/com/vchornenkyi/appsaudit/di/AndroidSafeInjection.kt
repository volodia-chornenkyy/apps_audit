package com.vchornenkyi.appsaudit.di

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

class AndroidSafeInjection {
    companion object {
        fun inject(activity: AppCompatActivity) {
            checkInjectorFactoryError(
                createLogMessage("activity", activity.javaClass.simpleName)
            ) {
                AndroidInjection.inject(activity)
            }
        }

        fun inject(fragment: Fragment) {
            checkInjectorFactoryError(
                createLogMessage("fragment", fragment.javaClass.simpleName)
            ) {
                AndroidSupportInjection.inject(fragment)
            }
        }

        private fun createLogMessage(targetType: String, className: String): String {
            return "There is no method marked with @ContributesAndroidInjector in the Dagger " +
                    "modules for $targetType $className"
        }

        private fun checkInjectorFactoryError(message: String, action: () -> Unit) {
            try {
                action.invoke()
            } catch (argumentException: IllegalArgumentException) {
                if (argumentException.message?.contains("No injector factory bound for Class") == true) {
                    Log.e("AndroidInjection", message)
                } else {
                    throw argumentException
                }
            }
        }
    }
}