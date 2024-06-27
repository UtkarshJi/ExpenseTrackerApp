package com.example.expensetracker.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Splash screen duration
    val splashTimeout = 1000L
    val version = "Alpha v0.01"
    // Trigger the timeout
    LaunchedEffect(true) {
        delay(splashTimeout)
        navController.navigate("homescreen") {
            popUpTo("home") {
                inclusive = true
            }
        }
    }

    // Splash screen layout
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFeeeeee)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo), // Your logo resource
                contentDescription = null,
                modifier = Modifier.size(210.dp)
            )
        }
        Column(verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)) {
            Text(text = version,
                fontSize = 10.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    val navController = rememberNavController()
    SplashScreen(navController)
}
