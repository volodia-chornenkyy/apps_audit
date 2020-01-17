package com.vchornenkyi.appsaudit.common.ui.recycler

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.State

class HorizontalSpaceItemDecoration(private val horizontalSpace: Int) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: State
    ) {

        outRect.left = horizontalSpace
        outRect.right = horizontalSpace
    }
}