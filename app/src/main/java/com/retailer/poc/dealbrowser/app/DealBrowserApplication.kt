package com.retailer.poc.dealbrowser.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class DealBrowserApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<DealBrowserApplication> {
        return DaggerDealBrowserComponent.builder().build()
    }
}
