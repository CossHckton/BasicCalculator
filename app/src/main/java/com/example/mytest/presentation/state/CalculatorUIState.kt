package com.example.mytest.presentation.state

import com.example.mytest.domain.model.Operation
import com.example.mytest.domain.model.OperationType

data class CalculatorUIState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val selectedOperationType: OperationType = OperationType.SUM,
    val resultText: String = "",
    val history: List<Operation> = emptyList(),
    val isCalculateEnable: Boolean = false
)