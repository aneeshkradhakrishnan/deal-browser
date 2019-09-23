package com.retailer.poc.dealbrowser.deals

import com.google.gson.annotations.SerializedName

data class DealList(

    @SerializedName("_id")
    val id: String?,

    @SerializedName("data")
    val data: List<DealItem>?,

    @SerializedName("type")
    val type: String
)
