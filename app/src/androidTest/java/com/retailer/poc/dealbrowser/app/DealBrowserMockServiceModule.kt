package com.retailer.poc.dealbrowser.app

import com.retailer.poc.dealbrowser.service.DealsMockService
import com.retailer.poc.dealbrowser.service.DealsService
import dagger.Provides

class DealBrowserMockServiceModule : DealBrowserServiceModule() {

    @Provides
    override fun provideDealService(): DealsService {
        return DealsMockService()
    }
}