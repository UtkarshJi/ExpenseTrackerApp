package com.example.expensetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.ui.Screens.HomeScreen
import com.example.expensetracker.ui.Screens.Screen2
import com.example.expensetracker.ui.Screens.SplashScreen
import com.example.expensetracker.ui.Screens.AddTransactionScreen
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            SplashScreen(navController = navController)
        }
        composable("homescreen") {
            HomeScreen(navController = navController)
        }
        composable("screen2") {
            Screen2(navController = navController)
        }
        composable("addTransaction") {
            AddTransactionScreen(navController = navController)
        }
    }
}
