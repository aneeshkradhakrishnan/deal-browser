package com.retailer.poc.dealbrowser.views

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.robots.DealsActivityRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DealDetailsActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(DealDetailsActivity::class.java, false, false)

    val eyes: DealsActivityRobot.Eyes = DealsActivityRobot.Eyes()

    @Test
    fun testDealDetails() {

        var intent = Intent()
        intent.putExtra("DEAL", getDealItem())
        activityRule.launchActivity(intent)

        eyes.seesDealImage()
                .seesTitle()
                .seesDescription()
                .seesSalePrice()
                .seesOriginalPrice()
                .seesAddToListButton()
                .seesAddToCartButton()
    }

    private fun getDealItem(): DealItem {
        return DealItem("548917fabeb9b0cadc529af3",
                "A3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eget metus id arcu auctor consectetur. Donec vestibulum, justo ut bibendum blandit, tellus nisi laoreet dolor, eget tempor sapien est eu enim. Pellentesque finibus risus ut lacus tristique pulvinar.",
                "f78e1c4d-93c5-4b92-ae47-7ea26be48c7c",
                "http://lorempixel.com/400/400/",
                1,
                "$12.99",
                "$9.99",
                "I‘m With Cupid Graphic Tee")
    }

}