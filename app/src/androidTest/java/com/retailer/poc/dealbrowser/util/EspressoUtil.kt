package com.retailer.poc.dealbrowser.util

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

object EspressoUtil {

    fun seesView(@IdRes id: Int) {
        Espresso.onView(ViewMatchers.withId(id))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun seesViewWithText(@IdRes id: Int, text: String) {
        Espresso.onView(ViewMatchers.withId(id))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }
}
