package com.retailer.poc.dealbrowser.viewmodels

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.DividerItemDecoration
import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.deals.DealList
import com.retailer.poc.dealbrowser.rx.RxHelper
import com.retailer.poc.dealbrowser.service.DealsService
import com.retailer.poc.dealbrowser.viewadapters.DealListAdapter
import javax.inject.Inject

class DealBrowserViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var adapter: DealListAdapter
    @Inject
    lateinit var dealService: DealsService
    @Inject
    lateinit var rxHelper: RxHelper

    lateinit var startDealDetailsActivity: (deal: DealItem) -> Unit
    lateinit var itemDivider: DividerItemDecoration

    var layoutType: ObservableField<String> = ObservableField("linear")
    var stagSpanCount: ObservableInt = ObservableInt(3)

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun fetchDealList() {
        subsribeOnLifeCycle(dealService.getDeals()
                .compose(rxHelper.singleTransformer())
                .subscribe(this::populateDeals, this::errorFetchingDeals))
    }

    fun itemClicked(deal: DealItem) {
        startDealDetailsActivity(deal)
    }

    fun switchView() {
        when (adapter.switchView()) {
            -1 -> layoutType.set("stag")
            else -> layoutType.set("linear")
        }
    }

    private fun populateDeals(dealList: DealList) {
        adapter.populateData(dealList.data, this)
    }

    private fun errorFetchingDeals(e: Throwable) {
        e.printStackTrace()
    }
}