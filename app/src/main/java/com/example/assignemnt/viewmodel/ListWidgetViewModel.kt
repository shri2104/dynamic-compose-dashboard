package com.example.assignemnt.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignemnt.Data.fake.ListDataGenerator
import com.example.assignemnt.Data.model.ListItem
import kotlinx.coroutines.launch

class ListWidgetViewModel(
    private val instanceId: String
) : ViewModel() {

    var uiState by mutableStateOf<ListUiState>(ListUiState.Loading)
        private set

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val data =ListDataGenerator.getListData(instanceId)
                uiState=ListUiState.Success(data)
            } catch (e: Exception) {
                uiState =ListUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
sealed class ListUiState {
    object Loading : ListUiState()
    data class Success(val data: List<ListItem>) : ListUiState()
    data class Error(val message: String) : ListUiState()
}