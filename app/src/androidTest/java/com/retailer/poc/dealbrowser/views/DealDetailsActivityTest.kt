package com.retailer.poc.dealbrowser.views

import android.content.Intent
import androidx.test.runner.AndroidJUnit4
import com.retailer.poc.dealbrowser.robots.DealsActivityRobot
import com.retailer.poc.dealbrowser.util.DealUtil
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DealDetailsActivityTest : EspressoBaseTest<DealDetailsActivity>(DealDetailsActivity::class.java) {

    val eyes: DealsActivityRobot.Eyes = DealsActivityRobot.Eyes()

    @Before
    fun startActivity() {
        var intent = Intent()
        intent.putExtra("DEAL", DealUtil.createDeal(1))
        startActivity(intent)
    }

    @Test
    fun testDealDetails() {
        eyes.seesDealImage()
                .seesTitle()
                .seesDescription()
                .seesSalePrice()
                .seesOriginalPrice()
                .seesAddToListButton()
                .seesAddToCartButton()
    }
}