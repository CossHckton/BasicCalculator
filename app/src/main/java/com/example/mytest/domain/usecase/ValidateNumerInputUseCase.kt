package com.example.mytest.domain.usecase

class ValidateNumerInputUseCase {
    private val regex = Regex("^-?\\d*\\.?\\d*$")

    fun isPartialValid(value: String): Boolean {
        return regex.matches(value)
    }

    fun toDoubleOrNull(value: String): Double? {
        if (value.isBlank()) return null
        if (value == "-" || value == "." || value == ".-") return null
        return value.toDoubleOrNull()
    }
}