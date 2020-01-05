package com.vchornenkyi.appsaudit.feature.list

import com.vchornenkyi.appsaudit.R
import com.vchornenkyi.appsaudit.base.BaseFragment
import javax.inject.Inject

class ListAppsFragment: BaseFragment(R.layout.fragment_list_apps) {

    @Inject
    lateinit var viewModel: ListAppsViewModel
}