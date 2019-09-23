package com.retailer.poc.dealbrowser.mvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.*
import com.squareup.picasso.Picasso

class RecyclerViewBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("url")
        fun setImageViewResource(imageView: ImageView, url: String?) {
            url?.let { it ->
                Picasso.get()
                        .load(it)
//                      .placeholder(R.drawable.user_placeholder)
//                      .error(R.drawable.user_placeholder_error)
                        .into(imageView)
            }
        }

        @JvmStatic
        @BindingAdapter("itemDivider")
        fun setItemDecorator(recyclerView: RecyclerView, orientation:Int) {
            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, orientation))
        }
    }
}