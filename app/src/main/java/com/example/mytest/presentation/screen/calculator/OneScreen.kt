package com.example.mytest.presentation.screen.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytest.presentation.viewmodel.CalculatorViewModel
import com.example.mytest.domain.model.OperationType
import androidx.compose.runtime.getValue

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel,
    onNavigateToHistory: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Calculadora básica")
        OutlinedTextField(
            value = uiState.firstNumber,
            onValueChange = viewModel::onFirstNumberChange,
            label = { Text("Número 1") },
            modifier = Modifier.Companion.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Companion.Decimal),
            singleLine = true
        )

        OutlinedTextField(
            value = uiState.secondNumber,
            onValueChange = viewModel::onSecondNumberChange,
            label = { Text("Número 2") },
            modifier = Modifier.Companion.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Companion.Decimal),
            singleLine = true
        )

        Text("Selecciona una operación")

        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OperationType.entries.forEach { operationType ->
                FilterChip(
                    selected = uiState.selectedOperationType == operationType,
                    onClick = { viewModel.operationTypeSelected(operationType) },
                    label = { Text(operationType.name) }
                )

            }
        }

        Button(
            onClick = viewModel::calculate,
            enabled = uiState.isCalculateEnable,
            modifier = Modifier.Companion.fillMaxWidth()
        ) {
            Text("Continuar")
        }

        if (uiState.resultText.isNotEmpty()) {
            Column(
                modifier = Modifier.Companion.padding(16.dp)
            ) {
                Text("Resultado")
                Spacer(modifier = Modifier.Companion.height(8.dp))
                Text(text = uiState.resultText)
            }
        }

        TextButton(
            onClick = onNavigateToHistory,
            modifier = Modifier.Companion.fillMaxWidth()
        ) {
            Text("Ver historial")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
private fun ScreenOnePreview() {

    CalculatorScreen(
        viewModel = viewModel()
    ) {

    }
}