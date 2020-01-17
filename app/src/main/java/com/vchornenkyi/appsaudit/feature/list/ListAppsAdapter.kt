package com.vchornenkyi.appsaudit.feature.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vchornenkyi.appsaudit.R
import com.vchornenkyi.appsaudit.domain.applisting.AndroidApp

class ListAppsAdapter : RecyclerView.Adapter<ListAppsViewHolder>() {

    private val data: MutableList<AndroidApp> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAppsViewHolder {
        return ListAppsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_app,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ListAppsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(list: List<AndroidApp>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}