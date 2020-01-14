package com.vchornenkyi.appsaudit.feature.list

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vchornenkyi.appsaudit.R
import com.vchornenkyi.appsaudit.base.BaseFragment
import com.vchornenkyi.appsaudit.domain.applisting.AndroidApp
import kotlinx.android.synthetic.main.fragment_list_apps.*
import javax.inject.Inject

class ListAppsFragment : BaseFragment(R.layout.fragment_list_apps) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ListAppsViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // test code
        tvApps.text = ""
        tvApps.movementMethod = ScrollingMovementMethod()

        observeListOfApps()
    }

    private fun observeListOfApps() {
        viewModel.installedAppsData.observe(this, Observer<List<AndroidApp>> {
            updateListOfApps(it)
        })
    }

    private fun updateListOfApps(list: List<AndroidApp>) {
        val stringBuilder = StringBuilder()
        list.forEach { app -> stringBuilder.append(app).append("\n\n") }
        tvApps.text = stringBuilder.toString()
    }
}