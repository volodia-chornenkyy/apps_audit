package com.vchornenkyi.appsaudit.feature.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vchornenkyi.appsaudit.R
import com.vchornenkyi.appsaudit.base.BaseFragment
import com.vchornenkyi.appsaudit.common.ui.px
import com.vchornenkyi.appsaudit.common.ui.recycler.HorizontalSpaceItemDecoration
import com.vchornenkyi.appsaudit.common.ui.recycler.VerticalSpaceItemDecoration
import com.vchornenkyi.appsaudit.common.ui.recycler.setDivider
import com.vchornenkyi.appsaudit.domain.applisting.AndroidApp
import kotlinx.android.synthetic.main.fragment_list_apps.*
import javax.inject.Inject

class ListAppsFragment : BaseFragment(R.layout.fragment_list_apps) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val listAppsAdapter = ListAppsAdapter()

    private val viewModel: ListAppsViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvApps.adapter = listAppsAdapter
        rvApps.setDivider(R.drawable.divider_list)
        rvApps.addItemDecoration(
            VerticalSpaceItemDecoration(
                context?.px(R.dimen.list_apps_item_vertical_space) ?: 0
            )
        )
        rvApps.addItemDecoration(
            HorizontalSpaceItemDecoration(
                context?.px(R.dimen.list_apps_item_horizontal_space) ?: 0
            )
        )
        observeListOfApps()
    }

    private fun observeListOfApps() {
        viewModel.installedAppsData.observe(this, Observer<List<AndroidApp>> {
            updateListOfApps(it)
        })
    }

    private fun updateListOfApps(list: List<AndroidApp>) {
        listAppsAdapter.updateData(list)
    }
}