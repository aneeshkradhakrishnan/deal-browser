package com.retailer.poc.dealbrowser.app

import com.google.gson.GsonBuilder
import com.retailer.poc.dealbrowser.service.DealsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
open class DealBrowserServiceModule {

    @Provides
    open fun provideDealService(): DealsService {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://target-deals.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(DealsService::class.java)
    }
}
