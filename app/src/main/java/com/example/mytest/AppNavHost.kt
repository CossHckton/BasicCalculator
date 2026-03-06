package com.example.mytest

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytest.ScreenRoutes.HistoricScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val calculatorViewModel: CalculatorViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MainScreen.nameFlow
    ) {
        composable(ScreenRoutes.MainScreen.nameFlow) {
            CalculatorScreen(
                viewModel = calculatorViewModel,
                onNavigateToHistory = {
                    navController.navigate(ScreenRoutes.HistoricScreen.nameFlow)
                }
            )
        }

        composable(HistoricScreen.nameFlow) {
            HistoricScreen(
                viewModel = calculatorViewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}