package com.example.mytest.domain.model

import com.example.mytest.domain.model.OperationType

data class Operation(
    val inputOne: Double,
    val inputTwo: Double,
    val type: OperationType,
    val result: Double
)