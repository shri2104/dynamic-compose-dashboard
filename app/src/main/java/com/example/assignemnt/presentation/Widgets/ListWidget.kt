package com.example.assignemnt.presentation.Widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignemnt.viewmodel.ListUiState
import com.example.assignemnt.viewmodel.ListWidgetViewModel

@Composable
fun ListWidget(instanceId: String) {

    val viewModel: ListWidgetViewModel = viewModel(
        key = "List-$instanceId",
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ListWidgetViewModel(instanceId) as T
            }
        }
    )

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {

        Text(
            text = instanceId.uppercase(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when (val state = viewModel.uiState) {
            is ListUiState.Loading -> CircularProgressIndicator()
            is ListUiState.Success -> {
                state.data.forEach {
                    Text("${it.name} ${it.surname}", modifier = Modifier.padding(4.dp))
                }
            }
            is ListUiState.Error -> {
                Text(state.message, color = Color.Red)
            }
        }
    }
}
