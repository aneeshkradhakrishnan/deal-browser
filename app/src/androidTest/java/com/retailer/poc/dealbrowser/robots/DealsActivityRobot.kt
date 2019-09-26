package com.retailer.poc.dealbrowser.robots

import com.retailer.poc.dealbrowser.R
import com.retailer.poc.dealbrowser.util.EspressoUtil

interface DealsActivityRobot {

    class Eyes {

        fun seesAddToListButton(): Eyes {
            EspressoUtil.seesViewWithText(R.id.add_to_list, "add to list")
            return this
        }

        fun seesAddToCartButton(): Eyes {
            EspressoUtil.seesViewWithText(R.id.add_to_cart, "add to cart")
            return this
        }

        fun seesTitle(): Eyes {
            EspressoUtil.seesViewWithText(R.id.deal_title, "I‘m With Cupid Graphic Tee")
            return this
        }

        fun seesSalePrice(): Eyes {
            EspressoUtil.seesViewWithText(R.id.sale_price, "$9.99")
            return this
        }

        fun seesOriginalPrice(): Eyes {
            EspressoUtil.seesViewWithText(R.id.original_price, "$12.99")
            return this
        }

        fun seesDescription(): Eyes {
            EspressoUtil.seesView(R.id.deal_description)
            return this
        }

        fun seesDealImage(): Eyes {
            EspressoUtil.seesView(R.id.deal_image)
            return this
        }
    }
}
