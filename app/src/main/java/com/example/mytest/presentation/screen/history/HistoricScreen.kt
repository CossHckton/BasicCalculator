package com.example.mytest.presentation.screen.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mytest.presentation.viewmodel.CalculatorViewModel
import androidx.compose.runtime.getValue

@Composable
fun HistoricScreen(
    viewModel: CalculatorViewModel,
    onBack: () -> Unit
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Historial")

        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.Companion.weight(1f)
            ) {
                Text("Volver")
            }

            Button(
                onClick = viewModel::clearHistory,
                modifier = Modifier.Companion.weight(1f),
                enabled = uiState.history.isNotEmpty()
            ) {
                Text("Eliminar todo")
            }
        }

        if (uiState.history.isEmpty()) {
            Text("No hay operaciones registradas")
        } else {
            LazyColumn(
                modifier = Modifier.Companion.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(uiState.history) { index, operation ->
                    Column(
                        modifier = Modifier.Companion
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(text = viewModel.formatOperation(operation))
                        TextButton(
                            onClick = { viewModel.deleteOperation(index) }
                        ) {
                            Text("Eliminar")
                        }
                    }
                }
            }
        }

    }

}