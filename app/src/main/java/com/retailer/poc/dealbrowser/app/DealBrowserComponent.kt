package com.retailer.poc.dealbrowser.app

import javax.inject.Singleton

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    DealBrowserDaggerModule::class,
    DealBrowserUiModule::class])
interface DealBrowserComponent : AndroidInjector<DealBrowserApplication>
