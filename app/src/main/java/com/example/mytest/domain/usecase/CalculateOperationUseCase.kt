package com.example.mytest.domain.usecase

import com.example.mytest.domain.model.OperationType

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