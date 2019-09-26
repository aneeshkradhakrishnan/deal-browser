package com.retailer.poc.dealbrowser.app

import dagger.android.AndroidInjector

class DealBrowserTestApplication : DealBrowserApplication() {

    override fun applicationInjector(): AndroidInjector<DealBrowserApplication> {
        return DaggerDealBrowserComponent
                .builder()
                .dealBrowserServiceModule(DealBrowserMockServiceModule())
                .build()
    }
}
