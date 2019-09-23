package com.retailer.poc.dealbrowser.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import com.retailer.poc.dealbrowser.deals.DealContent
import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.service.DealsService
import com.retailer.poc.dealbrowser.viewadapters.DealListAdapter
import javax.inject.Inject

class DealBrowserViewModel @Inject constructor():BaseViewModel() {

    @Inject lateinit var adapter: DealListAdapter
    @Inject lateinit var dealService: DealsService

    lateinit var layoutManager:RecyclerView.LayoutManager

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun fetchDealList() {
        adapter.populateData(DealContent.ITEMS)
        subsribeOnLifeCycle(dealService.getDeals().subscribe(this::populateDeals, this::errorFetchingDeals))
    }

    private fun populateDeals(list:List<DealItem>) {
        adapter.populateData(list)
    }

    private fun errorFetchingDeals(e:Throwable) {
        e.printStackTrace()
    }
}