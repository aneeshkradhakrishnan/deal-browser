package com.retailer.poc.dealbrowser.util

import com.retailer.poc.dealbrowser.deals.DealItem
import com.retailer.poc.dealbrowser.deals.DealList

object DealUtil {
    fun createDeal(index: Int): DealItem {
        return DealItem("548917fabeb9b0cadc529af${index}",
                "A${index}",
                "${index} - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eget metus id arcu auctor consectetur. Donec vestibulum, justo ut bibendum blandit, tellus nisi laoreet dolor, eget tempor sapien est eu enim. Pellentesque finibus risus ut lacus tristique pulvinar.",
                "f78e1c4d-93c5-4b92-${index}-7ea26be48c7c",
                "http://lorempixel.com/400/400/",
                index,
                "$1${index}.99",
                "$9.${index}9",
                "I‘m With Cupid ${index} Graphic Tee")
    }

    fun createDealList(num:Int): DealList {
        var list: MutableList<DealItem> = mutableListOf()
        for (x in 0 until num) {
            list.add(createDeal(x))
        }

        return DealList("listid", list, "listtype")
    }
}