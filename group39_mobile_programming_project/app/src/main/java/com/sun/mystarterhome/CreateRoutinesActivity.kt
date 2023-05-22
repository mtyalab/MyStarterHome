package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sun.mystarterhome.ui.theme.MyStarterHomeTheme




class CreateRoutinesActivity : ComponentActivity() {

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
                    CreateRoutinesBody(navController)
                }

            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateRoutinesBody(navController: NavHostController) {
    val name = remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = { CreateRoutinesTopBar(navController, showBackButton = true)  },
        content = {
            Column(
            ) {

                TextField(
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, top = 20.dp),
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text(text = "Routine Name")},
                    placeholder = { },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp,)
                        .background(Color(0xffffffff)),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "When",
                            fontSize = 23.sp,
                            modifier = Modifier
                                .padding(top = 20.dp, start = 20.dp, end = 40.dp, bottom = 5.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )
                    }

                }


                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp,)
                        .background(Color(0xffeeeeee)),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Want this routine to run automatically? Add an event below.",
                            modifier = Modifier
                                .padding(top = 20.dp, start = 40.dp, end = 40.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )
                    }

                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Add Event",
                        modifier = Modifier
                            .padding(top = 10.dp, start = 20.dp, end = 15.dp, bottom = 0.dp)
                            .weight(1f)
                            .wrapContentWidth(Alignment.End),
                        textAlign = TextAlign.End,
                        fontSize = 23.sp,
                        color = Color(0xff000000)
                    )

                    FloatingActionButton(
                        backgroundColor = Color(0xff0099d5),
                        contentColor = Color(0xffffffff),
                        modifier = Modifier
                            .padding( end = 20.dp, bottom = 0.dp),
                        onClick = {
                            navController.navigate(NavRoutes.SelectEvents.route)
                        }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                    }
                }


                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 0.dp,)
                        .background(Color(0xffffffff)),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Run these actions",
                            fontSize = 23.sp,
                            modifier = Modifier
                                .padding(top = 0.dp, start = 20.dp, end = 40.dp, bottom = 5.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )
                    }

                }


                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp,)
                        .background(Color(0xffeeeeee)),
                ) {
                    Column {
                        Text(
                            text = "No actions. Tap below to add one.",
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )
                    }

                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Add Action",
                        modifier = Modifier
                            .padding(top = 10.dp, start = 20.dp, end = 15.dp, bottom = 10.dp)
                            .weight(1f)
                            .wrapContentWidth(Alignment.End),
                        textAlign = TextAlign.End,
                        fontSize = 23.sp,
                        color = Color(0xff000000)
                    )

                    FloatingActionButton(
                        backgroundColor = Color(0xff0099d5),
                        contentColor = Color(0xffffffff),
                        modifier = Modifier
                            .padding( end = 20.dp, bottom = 20.dp),
                        onClick = {}) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                    }
                }



                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp,)
                        .background(Color(0xffffffff)),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "But only if",
                            fontSize = 23.sp,
                            modifier = Modifier
                                .padding(top = 0.dp, start = 20.dp, end = 40.dp, bottom = 5.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )
                    }

                }


                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp,)
                        .background(Color(0xffeeeeee)),
                ) {
                    Column {
                        Text(
                            text = "Add an event before adding conditions.",
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )
                    }

                }

            }
        },
    )
}

@Composable
fun CreateRoutinesTopBar(navController: NavHostController, showBackButton: Boolean = false){
    TopAppBar(
        title = {
            Text(
                text = "Create a Routine",
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
                        Icons.Default.Close,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Done,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
    )
}



