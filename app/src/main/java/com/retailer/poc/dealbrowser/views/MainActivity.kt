package com.retailer.poc.dealbrowser.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.retailer.poc.dealbrowser.R
import com.retailer.poc.dealbrowser.databinding.ActivityMainBinding
import com.retailer.poc.dealbrowser.viewmodels.DealBrowserViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModel:DealBrowserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.itemDivider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.vm = viewModel
        lifecycle.addObserver(viewModel)
    }
}
