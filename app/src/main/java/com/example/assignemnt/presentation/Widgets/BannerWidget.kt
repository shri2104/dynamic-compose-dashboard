package com.example.assignemnt.presentation.Widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignemnt.viewmodel.BannerViewModel

@Composable
fun BannerWidget(instanceId: String) {

    val viewModel: BannerViewModel =viewModel(
        key = "Banner-$instanceId",
        factory = object: ViewModelProvider.Factory {
            override fun <T :ViewModel> create(modelClass: Class<T>): T {
                return BannerViewModel(instanceId) as T
            }
        }
    )

    LazyRow(
        modifier=Modifier.padding(vertical = 8.dp),
        contentPadding=PaddingValues(horizontal = 16.dp),
        horizontalArrangement =Arrangement.spacedBy(12.dp)
    ) {
        items(viewModel.banners) { banner ->
            Column(
                modifier = Modifier
                    .width(180.dp)
                    .padding(12.dp)
            ) {
                Text(
                    text= banner.title,
                    fontWeight = FontWeight.Bold
                )
                Text(text=banner.subtitle)
            }
        }
    }
}