package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.sun.mystarterhome.ui.theme.MyStarterHomeTheme




class ThingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStarterHomeTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    ThingsBody()
                }

            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ThingsBody() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar()  },
        content = {
            Column(
                modifier = Modifier
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painterResource(id = R.drawable.things), contentDescription = "none", Modifier.size(150.dp))
                Text(
                    text = "No Things!",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
                Text(
                    text = "It looks like we didn't discover any devices",
                    modifier = Modifier
                        .padding(top = 10.dp, start = 40.dp, end = 40.dp),
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = "Try an option below",
                    modifier = Modifier
                        .padding(top = 10.dp, start = 40.dp, end = 40.dp, bottom = 20.dp),
                    textAlign = TextAlign.Center,
                )
                Divider()

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Row (
                        modifier = Modifier
                            .padding(top = 30.dp, start = 30.dp),
                    ) {
                        FloatingActionButton(
                            backgroundColor = Color(0xff0099d5),
                            contentColor = Color(0xffffffff),
                            onClick = {}) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "fab icon")
                        }
                        Text(
                            text = "Run discovery",
                            modifier = Modifier
                                .padding(top = 10.dp, start = 20.dp, end = 40.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff0099d5)
                        )
                    }

                    Row (
                        modifier = Modifier
                            .padding(top = 10.dp, start = 30.dp,),
                    ) {
                        FloatingActionButton(
                            backgroundColor = Color(0xff0099d5),
                            contentColor = Color(0xffffffff),
                            onClick = {}) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                        }
                        Text(
                            text = "Add a cloud account",
                            modifier = Modifier
                                .padding(top = 10.dp, start = 20.dp, end = 40.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff0099d5)
                        )
                    }

                    Row (
                        modifier = Modifier
                            .padding(top = 10.dp, start = 30.dp,),
                    ) {
                        FloatingActionButton(
                            backgroundColor = Color(0xff0099d5),
                            contentColor = Color(0xffffffff),
                            onClick = {}) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "fab icon")
                        }
                        Text(
                            text = "View our supported devices",
                            modifier = Modifier
                                .padding(top = 10.dp, start = 20.dp, end = 40.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff0099d5)
                        )
                    }

                    Row (
                        modifier = Modifier
                            .padding(top = 10.dp, start = 30.dp),
                    ) {
                        FloatingActionButton(
                            backgroundColor = Color(0xff0099d5),
                            contentColor = Color(0xffffffff),
                            onClick = {}) {
                            Icon(imageVector = Icons.Default.Email, contentDescription = "fab icon")
                        }
                        Text(
                            text = "Contact support",
                            modifier = Modifier
                                .padding(top = 10.dp, start = 20.dp, end = 40.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            color = Color(0xff0099d5)
                        )
                    }
                }
            }
        },
        bottomBar = { BottomBar(navController) }
    )
}

@Composable
fun TopBar(){
    TopAppBar(
        title = {
            Text(
                text = "My Starter Home",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xffffe400),
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
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

@Preview
@Composable
fun PreviewTopBar(){
    MaterialTheme{
        Surface {
            TopBar()
        }
    }
}


