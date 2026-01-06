package com.example.assignemnt.Data.model

data class WidgetMeta(
    val type: WidgetType,
    val instanceId: String
)
enum class WidgetType {
    BANNER,
    LIST
}
