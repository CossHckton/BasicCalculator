package com.example.mytest

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