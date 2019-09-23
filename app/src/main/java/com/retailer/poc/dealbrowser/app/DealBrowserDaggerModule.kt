package com.retailer.poc.dealbrowser.app

import com.google.gson.GsonBuilder
import com.retailer.poc.dealbrowser.rx.IoScheduler
import com.retailer.poc.dealbrowser.rx.MainScheduler
import com.retailer.poc.dealbrowser.service.DealsService
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class DealBrowserDaggerModule {

    @Provides
    fun provideDealService():DealsService {
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

//    @Provides
//    @IoScheduler
//    @Singleton
//    fun provideIOScheduler(): Scheduler {
//        return Schedulers.io()
//    }

//    @Provides
//    @Singleton
//    @MainScheduler
//    fun provideMainScheduler(): Scheduler {
//        return AndroidSchedulers.mainThread()
//    }
}
