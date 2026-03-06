package com.example.mytest

class CalculateOperationUseCase {
    operator fun invoke(
        firstNumber: Double,
        secondNumber: Double,
        operationType: OperationType
    ): Double {
        return when (operationType) {
            OperationType.SUM -> firstNumber + secondNumber
            OperationType.SUBTRAC -> firstNumber - secondNumber
            OperationType.MULTIPLY -> firstNumber * secondNumber
        }
    }
}