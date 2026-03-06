package com.example.mytest

data class CalculatorUIState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val selectedOperationType: OperationType = OperationType.SUM,
    val resultText: String = "",
    val history: List<Operation> = emptyList(),
    val isCalculateEnable: Boolean = false
)
