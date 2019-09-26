package com.retailer.poc.dealbrowser.robots

import com.retailer.poc.dealbrowser.R
import com.retailer.poc.dealbrowser.util.EspressoUtil

interface MainActivityRobot {

    class Hands {
        fun clickOnFAB(): Hands {
            return this;
        }
    }

    class Eyes {

        fun seesNumberOfItems(): Eyes {
            EspressoUtil.seesRecyclerViewItems(R.id.deals_view, 10)
            return this
        }

        fun seesTitleForTheItem(): Eyes {
            EspressoUtil.seesRecyclerViewIndexWithText(R.id.deals_view, 0,"I‘m With Cupid 0 Graphic Tee")
            return this
        }

        fun seesSalePriceForTheItem(): Eyes {
            EspressoUtil.seesRecyclerViewIndexWithText(R.id.deals_view, 0,"$9.09")
            return this
        }

        fun seesDealAisleForTheItem(): Eyes {
            EspressoUtil.seesRecyclerViewIndexWithText(R.id.deals_view, 0, "A0")
            return this
        }
    }
}
