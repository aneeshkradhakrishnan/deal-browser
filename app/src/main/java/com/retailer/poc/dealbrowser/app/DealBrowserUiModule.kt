package com.retailer.poc.dealbrowser.app

import com.retailer.poc.dealbrowser.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DealBrowserUiModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}
