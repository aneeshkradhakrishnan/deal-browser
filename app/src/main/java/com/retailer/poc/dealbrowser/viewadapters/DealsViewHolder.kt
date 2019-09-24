package com.retailer.poc.dealbrowser.viewadapters

import androidx.recyclerview.widget.RecyclerView
import com.retailer.poc.dealbrowser.databinding.DealListItemBinding
import com.retailer.poc.dealbrowser.databinding.DealStagItemBinding
import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.viewmodels.DealBrowserViewModel

class DealsViewHolder : RecyclerView.ViewHolder {

    private var itemBinding: DealListItemBinding? = null
    private var stagItemBinding: DealStagItemBinding? = null

    constructor(itemBinding: DealListItemBinding) : super(itemBinding.root) {
        this.itemBinding = itemBinding
    }

    constructor(stagItemBinding: DealStagItemBinding) : super(stagItemBinding.root) {
        this.stagItemBinding = stagItemBinding
    }

    init {
        itemBinding?.executePendingBindings()
        stagItemBinding?.executePendingBindings()
    }

    fun bind(dealItem: DealItem, dealBrowserVm: DealBrowserViewModel?) {
        itemBinding?.deal = dealItem
        itemBinding?.mainVm = dealBrowserVm
        stagItemBinding?.deal = dealItem
        stagItemBinding?.mainVm = dealBrowserVm
    }
}