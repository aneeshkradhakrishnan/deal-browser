package com.retailer.poc.dealbrowser.views

import android.content.Intent
import com.retailer.poc.dealbrowser.robots.MainActivityRobot
import org.junit.Before
import org.junit.Test


class MainActivityTest : EspressoBaseTest<MainActivity>(MainActivity::class.java) {

    val eyes: MainActivityRobot.Eyes = MainActivityRobot.Eyes()
    val hands: MainActivityRobot.Hands = MainActivityRobot.Hands()

    @Before
    fun startActivity() {
        startActivity(Intent())
    }

    @Test
    fun testOnServiceSuccess_itemsCount() {
        eyes.seesNumberOfItems()
    }

    @Test
    fun testItemDetails_forSecondItem() {
        eyes.seesTitleForTheItem()
                .seesSalePriceForTheItem()
                .seesDealAisleForTheItem()
    }
}