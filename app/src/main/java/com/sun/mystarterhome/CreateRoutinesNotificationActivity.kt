package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sun.mystarterhome.ui.theme.MyStarterHomeTheme
import java.util.*


class CreateRoutinesNotificationActivity : ComponentActivity() {

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
                    CreateRoutinesNotificationBody(navController)
                }

            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateRoutinesNotificationBody(navController: NavHostController) {
    val name = remember { mutableStateOf(TextFieldValue("Greetings")) }

    Scaffold(
        topBar = { CreateRoutinesNotificationTopBar(navController, showBackButton = true)  },
        content = {
            Column(
            ) {
                OpenNotificationDialog(navController)

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text(text = "Routine Name")},
                    placeholder = {  },
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

                    Image(painterResource(id = R.drawable.clock), contentDescription = "none",
                        Modifier
                            .size(30.dp)
                            .padding(top = 35.dp, start = 20.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Date & Time",
                            modifier = Modifier
                                .padding(top = 20.dp, start = 20.dp, end = 40.dp, bottom = 5.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xffaeaeae)
                        )
                        Text(
                            text = "The time is 12:00 AM",
                            modifier = Modifier
                                .padding(start = 20.dp, end = 40.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )

                    }

                    Icon(imageVector = Icons.Default.Settings,
                        contentDescription = "time icon",
                        modifier = Modifier
                            .padding(top = 35.dp, end = 20.dp)
                            .size(40.dp),)

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

                    Image(painterResource(id = R.drawable.chat), contentDescription = "none",
                        Modifier
                            .size(30.dp)
                            .padding(top = 35.dp, start = 20.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Notification",
                            modifier = Modifier
                                .padding(top = 20.dp, start = 20.dp, end = 40.dp, bottom = 5.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xffaeaeae)
                        )
                        Text(
                            text = "Send Notification: Welcome to Home",
                            modifier = Modifier
                                .padding(start = 20.dp, end = 40.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff000000)
                        )

                    }

                    Icon(imageVector = Icons.Default.Settings,
                        contentDescription = "setting icon",
                        modifier = Modifier
                            .padding(top = 35.dp, end = 20.dp)
                            .size(40.dp),)

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
                        onClick = {
                            navController.navigate(NavRoutes.SelectThingTime.route)
                        }) {
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
fun CreateRoutinesNotificationTopBar(navController: NavHostController, showBackButton: Boolean = false){
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

@Composable
fun OpenNotificationDialog(navController: NavHostController) {
    val name = remember { mutableStateOf(TextFieldValue("")) }
    var isDialogOpen by remember { mutableStateOf(true) }
    var isDialogLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isDialogOpen = true
    }





        if (isDialogOpen) {
            AlertDialog(
                onDismissRequest = {
                    isDialogOpen = false
                },
                title = { Text(text = "Enter a value") },
                text = {
                  if  (isDialogLoading){
                      Column() {
                          LinearProgressIndicator()
                          Text(text = "Creating new Routine")
                      }
                  } else {
                      TextField(
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(top = 20.dp),
                          value = name.value,
                          onValueChange = { name.value = it },
                          label = { Text(text = "Enter a value") },
                          placeholder = { },
                          colors = TextFieldDefaults.textFieldColors(
                              backgroundColor = Color.Transparent,
                              focusedIndicatorColor = Color.Black,
                              unfocusedIndicatorColor = Color.Black
                          ),
                          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                      )
                  }

                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            isDialogLoading = true

                            val intent = Intent(context, GreetingActivity::class.java)
                            context.startActivity(intent)

                        }
                    ) {
                        Text(text = "OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            isDialogOpen = false
                        }
                    ) {
                        Text(text = "CANCEL")
                    }
                }
            )
        }
    }

