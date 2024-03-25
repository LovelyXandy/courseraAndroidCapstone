package com.example.littlelemon
import android.content.Context
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Profile(context: Context?, navController: NavController?){
    //get data
    val sharedPreferences = context!!.getSharedPreferences(
        ContextCompat.getString(
            context,
            R.string.sharedPreferenceKey
        ), Context.MODE_PRIVATE)
    var firstName = remember { mutableStateOf(sharedPreferences.getString("firstName", "")) }
    var lastName = remember { mutableStateOf(sharedPreferences.getString("lastName", "")) }
    var email = remember { mutableStateOf(sharedPreferences.getString("email", "")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
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
                    "Profile",
                    style = MaterialTheme.typography.headlineLarge,
                    color = LittleLemonColor.cloud,
                    textAlign= TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                //needs a box with a green background?
            }
        }
        Row(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start=20.dp, end=20.dp).fillMaxWidth().align(Alignment.Start)) {
            Text(
                "Personal Information",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )
        }
        TextField(
            value = firstName.value!!,
            enabled=false,
            onValueChange = { firstName.value = it},
            label = { Text(text = "First Name") },
        )
        TextField(
            value = lastName.value!!,
            enabled=false,
            onValueChange = { lastName.value = it },
            label = { Text(text = "Last Name") },
        )
        TextField(
            value = email.value!!,
            enabled=false,
            onValueChange = { email.value = it },
            label = { Text(text = "E-mail address") },
        )
        Button(
            onClick = {
                sharedPreferences.edit().clear().apply()
                navController?.navigate(Onboarding.route)
            },
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = LittleLemonColor.yellow,
                contentColor = LittleLemonColor.green)
        ) {
            Text(
                text = "Log Out",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview(){
    Profile(null, null)
}