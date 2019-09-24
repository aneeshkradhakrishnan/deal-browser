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
                        .into(imageView)
            }
        }

        @JvmStatic
        @BindingAdapter(*["layoutType", "itemDivider", "spans"])
        fun setItemDecorator(recyclerView: RecyclerView, layoutType:String, decoration: DividerItemDecoration, spans:Int) {
            when(layoutType){
                "stag" -> {
                    recyclerView.layoutManager = StaggeredGridLayoutManager( spans, StaggeredGridLayoutManager.VERTICAL)
                    recyclerView.removeItemDecoration(decoration)
                }
                else -> {
                    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
                    recyclerView.addItemDecoration(decoration)
                }
            }
        }
    }
}