package com.vchornenkyi.appsaudit.common.ui.recycler

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.State

class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: State
    ) {

        if (!isFirstItem(parent, view)) {
            outRect.top = verticalSpaceHeight
        }
        if (isLastItem(parent, view).not()) {
            outRect.bottom = verticalSpaceHeight
        }
    }

    private fun isFirstItem(parent: RecyclerView, view: View) =
        parent.getChildAdapterPosition(view) == 0

    private fun isLastItem(
        parent: RecyclerView,
        view: View
    ) = parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1

}