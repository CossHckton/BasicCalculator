package com.example.mytest

sealed class ScreenRoutes : NameRoutes {
    object MainScreen : ScreenRoutes() {
        override val nameFlow: String = "main_screen"
    }

    object HistoricScreen : ScreenRoutes() {
        override val nameFlow: String = "historic_screen"
    }
}

interface NameRoutes {
    val nameFlow: String
}