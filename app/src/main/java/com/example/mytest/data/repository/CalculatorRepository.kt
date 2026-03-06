package com.example.mytest.data.repository

import com.example.mytest.domain.model.Operation

class CalculatorRepository {
    private val history = mutableListOf<Operation>()

    fun getHistory(): List<Operation> = history.toList()

    fun addOperation(operation: Operation) {
        history.add(0, operation)
    }

    fun removeOperation(index: Int) {
        if (index in history.indices) {
            history.removeAt(index)
        }
    }

    fun clearHistory() {
        history.clear()
    }
}