package com.retailer.poc.dealbrowser.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.retailer.poc.dealbrowser.R
import com.retailer.poc.dealbrowser.databinding.ActivityDealDetailBinding
import com.retailer.poc.dealbrowser.deals.DealItem

class DealDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDealDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_deal_detail)
        binding.deal = intent.getSerializableExtra("DEAL") as DealItem?
    }
}