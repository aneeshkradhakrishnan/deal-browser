package com.retailer.poc.dealbrowser.viewmodels

import androidx.recyclerview.widget.RecyclerView
import com.retailer.poc.dealbrowser.deals.DealContent
import com.retailer.poc.dealbrowser.viewadapters.DealListAdapter
import javax.inject.Inject

class DealBrowserViewModel @Inject constructor() {

    @Inject lateinit var adapter: DealListAdapter

    lateinit var layoutManager:RecyclerView.LayoutManager

    fun populateDealsList() {
        adapter.populateData(DealContent.ITEMS)
    }
}