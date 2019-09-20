package com.retailer.poc.dealbrowser.viewadapters

import androidx.recyclerview.widget.RecyclerView
import com.retailer.poc.dealbrowser.databinding.DealListItemBinding
import com.retailer.poc.dealbrowser.deals.DealItem

class DealsViewHolder(private val itemBinding: DealListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    init {
        itemBinding.executePendingBindings()
    }

    fun bind(dealItem: DealItem) {
        itemBinding.vm = dealItem
    }
}