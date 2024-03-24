package com.example.littlelemon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight(0.1F)){
            Image(
                painter = painterResource(
                    id = R.drawable.logo,

                    ),
                contentScale = ContentScale.FillHeight,
                contentDescription = "Logo Image",
                modifier = Modifier
                    .fillMaxHeight().padding(20.dp)
            )
            Image(
                painter = painterResource(
                    id = R.drawable.profile,

                    ),
                contentScale = ContentScale.FillHeight,
                contentDescription = "Profile Link",
                modifier = Modifier
                    .fillMaxHeight().padding(20.dp).clickable { navController.navigate(Profile.route) }
            )
        }
    }
}