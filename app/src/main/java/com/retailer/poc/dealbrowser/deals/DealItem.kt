package com.retailer.poc.dealbrowser.deals

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DealItem(

        @SerializedName("_id")
        val id: String?,

        @SerializedName("aisle")
        val aisle: String,

        @SerializedName("description")
        val description: String?,

        @SerializedName("guid")
        val guid: String,

        @SerializedName("image")
        var image: String?,

        @SerializedName("index")
        val index: Int?,

        @SerializedName("price")
        val originalPrice: String?,

        @SerializedName("salePrice")
        val salePrice: String?,

        @SerializedName("title")
        val title: String?
) : Serializable {

    override fun toString(): String {
        return title ?: ""
    }
}