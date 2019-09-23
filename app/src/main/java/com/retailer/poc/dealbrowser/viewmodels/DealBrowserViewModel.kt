package com.retailer.poc.dealbrowser.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import com.retailer.poc.dealbrowser.deals.DealContent
import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.deals.DealList
import com.retailer.poc.dealbrowser.rx.IoScheduler
import com.retailer.poc.dealbrowser.rx.MainScheduler
import com.retailer.poc.dealbrowser.service.DealsService
import com.retailer.poc.dealbrowser.viewadapters.DealListAdapter
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DealBrowserViewModel @Inject constructor():BaseViewModel() {

    @Inject lateinit var adapter: DealListAdapter
    @Inject lateinit var dealService: DealsService
//    @Inject @IoScheduler lateinit var ioScheduler: Scheduler
//    @Inject @MainScheduler lateinit var mainScheduler: Scheduler

    lateinit var layoutManager:RecyclerView.LayoutManager

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun fetchDealList() {
        adapter.populateData(DealContent.ITEMS)
        subsribeOnLifeCycle(dealService.getDeals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::populateDeals, this::errorFetchingDeals))
    }

    private fun populateDeals(dealList: DealList) {
        adapter.populateData(dealList.data)
    }

    private fun errorFetchingDeals(e:Throwable) {
        e.printStackTrace()
    }
}