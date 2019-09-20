package com.retailer.poc.dealbrowser.mvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.*

class RecyclerViewBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("resource")
        fun setImageViewResource(imageView: ImageView, resource: Int) {
            imageView.setImageResource(resource)
        }

        @JvmStatic
        @BindingAdapter("itemDivider")
        fun setItemDecorator(recyclerView: RecyclerView, orientation:Int) {
            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, orientation))
        }
    }
}