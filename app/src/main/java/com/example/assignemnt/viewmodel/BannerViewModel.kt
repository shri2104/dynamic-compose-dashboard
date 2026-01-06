package com.example.assignemnt.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignemnt.Data.fake.BannerDataGenerator

class BannerViewModel(instanceId: String) : ViewModel() {
    val banners = BannerDataGenerator.getBanner(instanceId)
}