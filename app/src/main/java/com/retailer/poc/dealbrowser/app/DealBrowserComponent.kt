package com.retailer.poc.dealbrowser.app

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    DealBrowserServiceModule::class,
    DealBrowserUiModule::class])
interface DealBrowserComponent : AndroidInjector<DealBrowserApplication>
