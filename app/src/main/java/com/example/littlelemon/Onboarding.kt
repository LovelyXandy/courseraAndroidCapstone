package com.example.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun Onboarding(navController: NavController?){
    var firstName : String by remember { mutableStateOf("") }
    var lastName : String by remember { mutableStateOf("") }
    var email: String by remember { mutableStateOf("") }
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("USER_PROFILE", Context.MODE_PRIVATE)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.Logo),
            contentDescription = "Logo Image"
        )
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = "First Name") },
        )
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = "First Name") },
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "E-mail address") },
        )
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Register",
                color = Color(0xFFEDEFEE)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OnbardingPreview(){
    Onboarding(null)
}