package com.retailer.poc.dealbrowser.service

import com.retailer.poc.dealbrowser.deals.DealList
import com.retailer.poc.dealbrowser.util.DealUtil
import io.reactivex.Single

//This is an easy go
//it should be done with mock webserver and dispatching the json matching request
class DealsMockService : DealsService {
    override fun getDeals(): Single<DealList> {
        return Single.just(DealUtil.createDealList(10))
    }
}