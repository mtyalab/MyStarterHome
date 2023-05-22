package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sun.mystarterhome.ui.theme.MyStarterHomeTheme




class SelectAnActionActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStarterHomeTheme {
                val navController = rememberNavController()
                BackHandler() {
                    navController.navigateUp()
                }
                // A surface container using the 'background' color from the theme
                Surface {
                    SelectAnActionBody(navController)
                }

            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectAnActionBody(navController: NavHostController) {

    Scaffold(
        topBar = { SelectAnActionTopBar(navController, showBackButton = true)  },
        content = {
            TabActionComponent(navController)
        },
    )
}

@Composable
fun SelectAnActionTopBar(navController: NavHostController, showBackButton: Boolean = false){
    TopAppBar(
        title = {
            Text(
                text = "Select an Action",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xffffe400),
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TabActionComponent(navController: NavHostController) {
    // Tab items
    val tabs = listOf("THINGS", "SCENES", "ROUTINES")

    // Selected tab index
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        // Tab Row
        TabRow(selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.White,
            contentColor = Color.Black,
            modifier = Modifier.fillMaxWidth()) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        // Content for each tab
        when (selectedTabIndex) {
            0 -> ActionThingsTabContent(navController)
            1 -> ActionScenesTabContent()
            2 -> ActionRoutinesTabContent()
        }
    }
}

@Composable
fun ActionThingsTabContent(navController: NavHostController) {
    Column() {
        Text(
            text = "Enter your notification text here.",
            modifier = Modifier
                .padding(top = 15.dp, start = 20.dp).
                    clickable {
navController.navigate(NavRoutes.CreateRoutinesNotification.route)
                    }
        )
    }
}

@Composable
fun ActionScenesTabContent() {
    Text(text = "Scenes Tab Content")
}

@Composable
fun ActionRoutinesTabContent() {
    Text(text = "Routines Tab Content")
}


