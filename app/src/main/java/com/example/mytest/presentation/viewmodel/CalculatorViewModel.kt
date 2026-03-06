package com.example.mytest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mytest.data.repository.CalculatorRepository
import com.example.mytest.domain.model.Operation
import com.example.mytest.domain.model.OperationType
import com.example.mytest.domain.usecase.CalculateOperationUseCase
import com.example.mytest.domain.usecase.ValidateNumerInputUseCase
import com.example.mytest.presentation.state.CalculatorUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.text.DecimalFormat

class CalculatorViewModel(
    private val repository: CalculatorRepository = CalculatorRepository(),
    private val calculateOperationUseCase: CalculateOperationUseCase = CalculateOperationUseCase(),
    private val validateNumerInputUseCase: ValidateNumerInputUseCase = ValidateNumerInputUseCase()
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        CalculatorUIState(
            history = repository.getHistory()
        )
    )

    val uiState: StateFlow<CalculatorUIState> = _uiState

    fun onFirstNumberChange(value: String) {
        if (!validateNumerInputUseCase.isPartialValid(value)) return

        _uiState.update {
            it.copy(firstNumber = value)
        }
        updateCalculateButtonState()
    }

    fun onSecondNumberChange(value: String) {
        if (!validateNumerInputUseCase.isPartialValid(value)) return

        _uiState.update {
            it.copy(secondNumber = value)
        }
        updateCalculateButtonState()
    }

    fun operationTypeSelected(operationType: OperationType) {
        _uiState.update {
            it.copy(selectedOperationType = operationType)
        }
    }

    fun calculate() {
        val state = _uiState.value

        val first = validateNumerInputUseCase.toDoubleOrNull(state.firstNumber) ?: return
        val second = validateNumerInputUseCase.toDoubleOrNull(state.secondNumber) ?: return

        val result = calculateOperationUseCase(
            firstNumber = first,
            secondNumber = second,
            operationType = state.selectedOperationType
        )

        val operation = Operation(
            inputOne = first,
            inputTwo = second,
            type = state.selectedOperationType,
            result = result
        )

        repository.addOperation(operation)

        _uiState.update {
            it.copy(
                resultText = result.toString(),
                history = repository.getHistory()
            )
        }
    }

    fun deleteOperation(index: Int) {
        repository.removeOperation(index)
        _uiState.update {
            it.copy(history = repository.getHistory())
        }
    }

    fun clearHistory() {
        repository.clearHistory()
        _uiState.update {
            it.copy(history = emptyList())
        }
    }

    fun formatOperation(operation: Operation): String {
        return "${operation.inputOne} ${operation.type} ${operation.inputTwo} = ${operation.result}"
    }

    fun updateCalculateButtonState() {
        val state = _uiState.value
        val firstValid = validateNumerInputUseCase.toDoubleOrNull(state.firstNumber) != null
        val secondValid = validateNumerInputUseCase.toDoubleOrNull(state.secondNumber) != null

        _uiState.update {
            it.copy(
                isCalculateEnable = firstValid && secondValid
            )
        }
    }

    private fun formatNumber(value: Double): String {
        val decimalFormat = DecimalFormat("#.##########")
        return decimalFormat.format(decimalFormat)
    }

}