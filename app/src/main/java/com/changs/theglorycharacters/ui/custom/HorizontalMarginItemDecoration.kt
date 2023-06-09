package com.changs.theglorycharacters.ui.custom

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalMarginItemDecoration(context: Context, horizontalMarginInDp: Int) :
    RecyclerView.ItemDecoration() {

    private val horizontalMarginInPx: Int =
        context.resources.getDimension(horizontalMarginInDp).toInt()

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.right = horizontalMarginInPx
        outRect.left = horizontalMarginInPx
    }

}