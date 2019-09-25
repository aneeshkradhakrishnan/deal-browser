package com.retailer.poc.dealbrowser.viewmodels

import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.deals.DealList
import com.retailer.poc.dealbrowser.rx.RxHelper
import com.retailer.poc.dealbrowser.service.DealsService
import com.retailer.poc.dealbrowser.viewadapters.DealListAdapter
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verifyAll
import io.reactivex.Single
import io.reactivex.SingleTransformer
import org.junit.Assert
import org.junit.Test

class DealBrowserViewModelTest: BaseKTest() {

    @RelaxedMockK
    lateinit var adpter: DealListAdapter

    @RelaxedMockK
    lateinit var dealerService: DealsService

    @MockK
    lateinit var rxHelper: RxHelper

    @InjectMockKs
    var subject = DealBrowserViewModel()

    @Test
    fun fetchList_setsData() {
        var dealItem: DealItem = mockk()
        var dealList: DealList = mockk()
        every { dealList.data } returns listOf(dealItem)
        every { dealerService.getDeals() } returns Single.just(dealList)
        every { rxHelper.singleTransformer<Any>() } returns SingleTransformer { s -> s }

        subject.fetchDealList()

        verifyAll { adpter.populateData(listOf(dealItem), subject) }
    }

    @Test
    fun itemClicked_opensDealsDetails() {
        var listenerStartActivity: (deal: DealItem) -> Unit = mockk()
        var dealItem: DealItem = mockk()
        every { listenerStartActivity(dealItem) } returns Unit

        subject.startDealDetailsActivity = listenerStartActivity
        subject.itemClicked(dealItem)
        verifyAll { listenerStartActivity(dealItem) }
    }

    @Test
    fun switchView_togglesTheView() {
        every { subject.adapter.switchView() } returns -1
        subject.switchView()
        Assert.assertEquals(subject.layoutType.get(), "stag")

        every { subject.adapter.switchView() } returns 1
        subject.switchView()
        Assert.assertEquals(subject.layoutType.get(), "linear")
    }
}