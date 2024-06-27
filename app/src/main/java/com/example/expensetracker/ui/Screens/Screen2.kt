package com.example.expensetracker.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavController) {
    var transactions by remember { mutableStateOf(sampleTransactions) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("addTransaction")
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1E1E1E))
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                Text(
                    text = "UtkarshJi",
                    color = Color(0xFFe6ecf8),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Welcome back!",
                    color = Color(0xFFe6ecf8),
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                BalanceCard()
                Spacer(modifier = Modifier.height(16.dp))
                IncomeExpenseDashboardCard()
                Spacer(modifier = Modifier.height(16.dp))
                TransactionsList(transactions = transactions, navController = navController)
            }
        }
    )
}

@Composable
fun BalanceCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0A74DA),
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Total balance",
                fontSize = 18.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "₹23,30,127.39",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Total",
                fontSize = 18.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Income",
                        tint = Color.Green
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Income",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
                Text(
                    text = "+₹1,17,755.00",
                    fontSize = 16.sp,
                    color = Color.Green
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expense",
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Expense",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
                Text(
                    text = "-₹10,87,627.61",
                    fontSize = 16.sp,
                    color = Color.Red
                )
            }
        }
    }
}

@Composable
fun IncomeExpenseDashboardCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E1E1E))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IncomeCard()
        Spacer(modifier = Modifier.width(16.dp))
        ExpenseCard()
    }
}

@Composable
fun IncomeCard() {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2A2A2A)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Income",
                color = Color(0xFF00C853),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "₹1,17,755.00",
                color = Color(0xFFe6ecf8),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun ExpenseCard() {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2A2A2A)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Expense",
                color = Color(0xFFFF5252),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "₹9,87,795.00",
                color = Color(0xFFe6ecf8),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

data class Transaction(
    val description: String,
    val amount: String,
    val date: String,
    val transactionType: String = "",
    val tags: String = "",
    val note: String = ""
)

val sampleTransactions = listOf(
    Transaction("Koramangala to Home Auto", "₹9,87,795.00", "12 Mon - 07:30 AM"),
    Transaction("Home to Koramangala", "₹0.00", "11 Sun - 05:30 PM")
)

@Composable
fun TransactionsList(transactions: List<Transaction>, navController: NavController) {
    LazyColumn {
        items(transactions) { transaction ->
            TransactionItem(transaction)
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
            contentColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = transaction.description)
                Text(text = transaction.date, fontSize = 12.sp)
                Text(text = transaction.transactionType, fontSize = 12.sp, color = Color.Gray)
                Text(text = transaction.tags, fontSize = 12.sp, color = Color.Gray)
                Text(text = transaction.note, fontSize = 12.sp, color = Color.Gray)
            }
            Text(text = transaction.amount, color = Color.Red)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultScreen2Preview() {
    Screen2(navController = NavController(LocalContext.current))
}
