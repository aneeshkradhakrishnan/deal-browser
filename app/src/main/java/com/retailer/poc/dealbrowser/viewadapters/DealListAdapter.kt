package com.retailer.poc.dealbrowser.viewadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.retailer.poc.dealbrowser.R
import com.retailer.poc.dealbrowser.databinding.DealListItemBinding

import com.retailer.poc.dealbrowser.deals.DealItem
import javax.inject.Inject

class DealListAdapter @Inject constructor() : RecyclerView.Adapter<DealsViewHolder>() {

    private var data: List<DealItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return DealsViewHolder(DealListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: DealsViewHolder, position: Int) {
        data?.get(position)?.let { holder.bind(it) }
    }

    fun populateData(list: List<DealItem>?) {
        data = list
        notifyDataSetChanged()
    }
}
