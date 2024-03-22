package com.example.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Onboarding(navController: NavController?){
    var firstName : String by remember { mutableStateOf("") }
    var lastName : String by remember { mutableStateOf("") }
    var email: String by remember { mutableStateOf("") }
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("USER_PROFILE", Context.MODE_PRIVATE)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.logo),
            contentDescription = "Logo Image",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
        )
        Box(modifier=Modifier.background(LittleLemonColor.green).padding(top=50.dp, bottom=50.dp).fillMaxWidth().align(Alignment.CenterHorizontally)) {
            Text("Let's get to know you", style = MaterialTheme.typography.headlineSmall, color=LittleLemonColor.yellow)
            //needs a surface with a green background?
        }
        Text("Personal Information", style=MaterialTheme.typography.headlineSmall)
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = "First Name") },
        )
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = "Last Name") },
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "E-mail address") },
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OnboardingPreview(){
    Onboarding(null)
}