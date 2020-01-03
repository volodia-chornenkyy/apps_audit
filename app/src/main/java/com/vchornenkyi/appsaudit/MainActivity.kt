package com.vchornenkyi.appsaudit

import com.vchornenkyi.appsaudit.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    @Inject
    lateinit var viewModel: ListAppsViewModel
}
