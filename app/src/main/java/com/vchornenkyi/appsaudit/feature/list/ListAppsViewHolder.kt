package com.vchornenkyi.appsaudit.feature.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vchornenkyi.appsaudit.R
import com.vchornenkyi.appsaudit.domain.applisting.AndroidApp

class ListAppsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(androidApp: AndroidApp) {
        itemView.findViewById<TextView>(R.id.tvAppName).text = androidApp.name
        itemView.findViewById<TextView>(R.id.tvPackageName).text = androidApp.packageName
    }
}