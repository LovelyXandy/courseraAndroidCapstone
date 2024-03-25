package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getString
import androidx.navigation.NavController
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Onboarding(context: Context?, navController: NavController?){
    var firstName : String by remember { mutableStateOf("") }
    var lastName : String by remember { mutableStateOf("") }
    var email: String by remember { mutableStateOf("") }
    val sharedPreferences by lazy {context!!.getSharedPreferences(getString(context, R.string.sharedPreferenceKey), Context.MODE_PRIVATE)}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxHeight(0.25F)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.logo,

                ),
                contentScale = ContentScale.FillHeight,
                contentDescription = "Logo Image",
                modifier = Modifier
                    .fillMaxHeight(0.5F).padding(20.dp)
            )
            Row(
                modifier = Modifier.background(LittleLemonColor.green)
                    .padding(top = 20.dp, bottom = 20.dp, start=20.dp, end=20.dp).fillMaxWidth()
            ) {
                Text(
                    "Let's get to know you",
                    style = MaterialTheme.typography.headlineLarge,
                    color = LittleLemonColor.cloud,
                    textAlign= TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                //needs a box with a green background?
            }
        }
        Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start=20.dp, end=20.dp).fillMaxWidth().align(Alignment.Start)) {
            Text(
                "Personal Information",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )
        }
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
            onClick = {
                      if(
                          firstName.isNotBlank() &&
                          lastName.isNotBlank() &&
                          email.isNotBlank()
                      ){
                          sharedPreferences.edit()
                              .putString("firstName", firstName)
                              .putString("lastName", lastName)
                              .putString("email", email)
                              .putBoolean("userRegistered", true)
                              .apply()
                          Toast.makeText(
                              context,
                              "Registration successful. Thank You!",
                              Toast.LENGTH_LONG
                          ).show()
                          navController?.navigate(Home.route)
                      } else{
                          Toast.makeText(
                              context,
                              "Registration unsuccessful.\nPlease enter all data.",
                              Toast.LENGTH_LONG
                          ).show()
                      }
            },
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = LittleLemonColor.yellow,
                contentColor = LittleLemonColor.green)
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OnboardingPreview(){
    Onboarding(null, null)
}