package com.example.littlelemon
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Home(context: Context?, navController: NavController?, databaseMenuItems: List<MenuItem>?){
    var searchPhrase by remember {
        mutableStateOf("")
    } //needed for search box and filtering
    var categories = databaseMenuItems!!.map {
        it.category.replaceFirstChar { firstLetter -> firstLetter.uppercase() }
    }.toMutableSet() //make a set of menu items
    categories.add("All")
    val selectedCategory = remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight(0.1F).fillMaxWidth()){
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
                    .fillMaxHeight().padding(5.dp).clickable { navController!!.navigate(Profile.route) }
            )
        }
        Column(modifier = Modifier.fillMaxHeight()){
        Column(modifier = Modifier.background(LittleLemonColor.green), verticalArrangement=Arrangement.Top
        ) {
            Column()
            {
                Row(modifier = Modifier.padding(start=10.dp, end=10.dp,top=5.dp, bottom=0.dp)) {
                    Text(
                        text = stringResource(id = R.string.title),
                        fontSize = 64.sp,
                        lineHeight = 48.sp,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = LittleLemonColor.yellow
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(start = 10.dp, end=10.dp, top=0.dp, bottom=5.dp)
                ) {
                    Column(modifier = Modifier.padding(1.dp), verticalArrangement=Arrangement.Top) {
                        Text(
                            text = stringResource(id = R.string.location),
                            fontSize = 48.sp,
                            style = MaterialTheme.typography.headlineMedium,
                            color = LittleLemonColor.cloud
                        )
                        Text(
                            text = stringResource(id = R.string.description),
                            style = MaterialTheme.typography.bodyMedium,
                            color = LittleLemonColor.cloud,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(bottom = 20.dp, end = 20.dp)
                                .fillMaxWidth(0.6f)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.heroimage),
                        contentDescription = "Upper Panel Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .width(130.dp)
                            .height(130.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                Row(modifier = Modifier.padding(start = 5.dp, end=5.dp, top=0.dp, bottom=5.dp)) {
                    //search box

                    TextField(
                        value = searchPhrase,
                        onValueChange = {
                            searchPhrase = it
                        },
                        label = { Text("Enter Search Phrase") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = ""
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 2.dp, end = 2.dp)
                    )
                }
            }

            Row(modifier = Modifier.background(Color(0xFFFFFFFF))) {
                var databaseMenuItemsSearched = databaseMenuItems

                if (searchPhrase.isNotEmpty()) {
                    databaseMenuItemsSearched = databaseMenuItems.filter {
                        it.title.contains(
                            searchPhrase,
                            ignoreCase = true
                        )
                    }
                }
                var databaseMenuItemsFiltered =
                    if (selectedCategory.value == "" || selectedCategory.value == "all") {
                        databaseMenuItemsSearched
                    } else {
                        databaseMenuItemsSearched.filter {
                            it.category.contains(
                                selectedCategory.value,
                                ignoreCase = true
                            )
                        }
                    }
                Column(modifier = Modifier.fillMaxHeight()) {
                    Text(
                        text = stringResource(id = R.string.order_for_takeaway),
                        fontSize = 36.sp,
                        style = MaterialTheme.typography.headlineMedium,
                        color = LittleLemonColor.charcoal,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .horizontalScroll(rememberScrollState())
                            .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
                    ) {
                        for (category in categories) {
                            val clicked = remember {
                                mutableStateOf(false)
                            }
                            Button(
                                onClick = {
                                    clicked.value = !clicked.value
                                    selectedCategory.value = category
                                },
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = LittleLemonColor.charcoal,
                                    containerColor = LittleLemonColor.cloud
                                ),
                                modifier = Modifier.clip(CircleShape)
                            ) {
                                Text(
                                    text = category,
                                    fontSize = 24.sp,
                                    style = MaterialTheme.typography.headlineMedium,
                                )
                            }
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                        thickness = 1.dp,
                        color = LittleLemonColor.charcoal
                    )
                    MenuItems(navController!!, databaseMenuItemsFiltered)
                }
            }
        }
        }
    }
}

@Composable
fun MenuItems(navController: NavController, menuItems: List<MenuItem> = listOf()){
    LazyColumn (modifier = Modifier.fillMaxHeight()) {
        itemsIndexed(menuItems) { _, menuItem ->
            MenuDish(navController, menuItem)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuDish(navController: NavController, menuItem: MenuItem) {
    Card(){
    Row(modifier=Modifier.fillMaxWidth().padding(8.dp)){
            Column(){
                Text(text=menuItem.title, style=MaterialTheme.typography.headlineMedium)
                Text(text=menuItem.description, style=MaterialTheme.typography.bodyMedium,
                    modifier=Modifier.fillMaxWidth(0.75f).padding(top=5.dp, bottom=5.dp)
                )
                Text(text=String.format("$%.2f",menuItem.price), style=MaterialTheme.typography.bodyMedium)
            }
            GlideImage(
                model = menuItem.imageUrl,
                contentDescription="Image of ${menuItem.title}",
                modifier= Modifier.clip(RoundedCornerShape(1.dp)).size(90.dp, 90.dp)
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = LittleLemonColor.charcoal
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    Home(null, null, null)
}