package com.retailer.poc.dealbrowser.viewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.retailer.poc.dealbrowser.databinding.DealListItemBinding
import com.retailer.poc.dealbrowser.databinding.DealStagItemBinding
import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.viewmodels.DealBrowserViewModel
import javax.inject.Inject

class DealListAdapter @Inject constructor() : RecyclerView.Adapter<DealsViewHolder>() {

    private var data: List<DealItem>? = null
    private var dealBrowserVm: DealBrowserViewModel? = null
    private var viewType: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsViewHolder {
        when (viewType) {

            -1 -> {
                val inflater: LayoutInflater = LayoutInflater.from(parent.context)
                return DealsViewHolder(DealStagItemBinding.inflate(inflater, parent, false))
            }

            else -> {
                val inflater: LayoutInflater = LayoutInflater.from(parent.context)
                return DealsViewHolder(DealListItemBinding.inflate(inflater, parent, false))
            }
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: DealsViewHolder, position: Int) {
        data?.get(position)?.let { holder.bind(it, dealBrowserVm) }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType;
    }

    fun populateData(list: List<DealItem>?, dealBrowserViewModel: DealBrowserViewModel?) {
        data = list
        dealBrowserVm = dealBrowserViewModel
        notifyDataSetChanged()
    }

    fun switchView(): Int {
        viewType *= -1
        notifyDataSetChanged()
        return viewType
    }

}
