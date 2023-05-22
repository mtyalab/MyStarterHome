package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sun.mystarterhome.ui.theme.MyStarterHomeTheme




class SelectRoutines2Activity : ComponentActivity() {

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
                    SelectRoutines2Body(navController)
                }

            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectRoutines2Body(navController: NavHostController) {

    Scaffold(
        topBar = { SelectRoutines2TopBar(navController, showBackButton = true)  },
        content = {
            Column(
            ) {
                Row (
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp),
                ) {
                    FloatingActionButton(
                        backgroundColor = Color(0xff0099d5),
                        contentColor = Color(0xffffffff),
                        onClick = {
                           navController.navigate(NavRoutes.CreateRoutines.route)
                        }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                    }
                    Text(
                        text = "Create a new Routine",
                        modifier = Modifier
                            .padding(top = 10.dp, start = 20.dp, end = 40.dp, bottom = 20.dp),
                        textAlign = TextAlign.Center,
                        color = Color(0xff000000)
                    )
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp,)
                        .background(Color.White),
                ) {
                    Icon(imageVector = Icons.Default.Email,
                        contentDescription = "account icon",
                        modifier = Modifier
                            .padding(top = 35.dp, start = 20.dp),)

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Greeting",
                            modifier = Modifier
                                .padding(top = 20.dp, start = 20.dp, end = 40.dp, bottom = 5.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )
                        Text(
                            text = "Last Run: Never",
                            modifier = Modifier
                                .padding(start = 20.dp, end = 40.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xffaeaeae)
                        )
                    }

                }
            }
        },
    )
}

@Composable
fun SelectRoutines2TopBar(navController: NavHostController, showBackButton: Boolean = false){
    TopAppBar(
        title = {
            Text(
                text = "Select a Routine",
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



