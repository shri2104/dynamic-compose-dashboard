package com.example.assignemnt.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignemnt.Data.model.WidgetType
import com.example.assignemnt.presentation.Widgets.BannerWidget
import com.example.assignemnt.presentation.Widgets.ListWidget
import com.example.assignemnt.viewmodel.DashboardViewModel

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = viewModel()) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(viewModel.widgets) { widget ->
            when (widget.type) {
                WidgetType.BANNER -> BannerWidget(widget.instanceId)
                WidgetType.LIST -> ListWidget(widget.instanceId)
            }
        }
    }

}