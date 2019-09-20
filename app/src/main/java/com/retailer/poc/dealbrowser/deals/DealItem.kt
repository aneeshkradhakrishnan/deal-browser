package com.retailer.poc.dealbrowser.deals

class DealItem(var index: Int, var id: String, var title: String, var description:
                String, var originalPrice: String, var salePrice:
                String, var image: Int, var aisle: String) {

    override fun toString(): String {
        return title
    }
}