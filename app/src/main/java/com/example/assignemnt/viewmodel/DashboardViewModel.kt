package com.example.assignemnt.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignemnt.Data.model.WidgetMeta
import com.example.assignemnt.Data.model.WidgetType

class DashboardViewModel : ViewModel() {

    val widgets = listOf(
        WidgetMeta(WidgetType.BANNER, "pokemon"),
        WidgetMeta(WidgetType.BANNER, "cars"),
        WidgetMeta(WidgetType.LIST, "movies"),
        WidgetMeta(WidgetType.LIST, "shows")
    )
}
