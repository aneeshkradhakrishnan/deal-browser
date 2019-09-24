package com.retailer.poc.dealbrowser.viewmodels

import android.util.Log
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.retailer.poc.dealbrowser.deals.DealContent
import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.deals.DealList
import com.retailer.poc.dealbrowser.rx.IoScheduler
import com.retailer.poc.dealbrowser.rx.MainScheduler
import com.retailer.poc.dealbrowser.service.DealsService
import com.retailer.poc.dealbrowser.viewadapters.DealListAdapter
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DealBrowserViewModel @Inject constructor():BaseViewModel() {

    @Inject lateinit var adapter: DealListAdapter
    @Inject lateinit var dealService: DealsService

    var layoutType: ObservableField<String> = ObservableField("linear")
    var stagSpanCount: ObservableInt = ObservableInt(3)
    lateinit var itemDivider: DividerItemDecoration

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun fetchDealList() {
        subsribeOnLifeCycle(dealService.getDeals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::populateDeals, this::errorFetchingDeals))
    }

    fun itemClicked(deal: DealItem) {
        Log.e("deal", deal.toString())
    }

    fun switchView() {
        when(adapter.switchView()){
            -1 -> layoutType.set("stag")
            else -> layoutType.set("linear")
        }
    }

    private fun populateDeals(dealList: DealList) {
        adapter.populateData(dealList.data, this)
    }

    private fun errorFetchingDeals(e:Throwable) {
        e.printStackTrace()
    }
}