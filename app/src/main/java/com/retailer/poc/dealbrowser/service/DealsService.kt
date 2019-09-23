package com.retailer.poc.dealbrowser.service

import com.retailer.poc.dealbrowser.deals.DealList
import io.reactivex.Single
import retrofit2.http.GET

interface DealsService {

    @GET("api/deals")
    fun getDeals(): Single<DealList>
}