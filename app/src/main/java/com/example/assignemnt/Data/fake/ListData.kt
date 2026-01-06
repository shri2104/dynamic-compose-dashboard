package com.example.assignemnt.Data.fake

import com.example.assignemnt.Data.model.ListItem
import kotlinx.coroutines.delay

object ListDataGenerator {

    suspend fun getListData(instanceId: String): List<ListItem> {
        delay(1500)
        if (instanceId == "error") {
            throw RuntimeException("Fake error")
        }
        return List(10) {
            ListItem(
                name = "Name $it",
                surname = "From $instanceId"
            )
        }
    }
}
