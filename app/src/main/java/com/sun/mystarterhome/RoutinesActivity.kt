package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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




class RoutinesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStarterHomeTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    RoutinesBody()
                }

            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RoutinesBody() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { RoutinesTopBar()  },
        content = {
            Column(
                modifier = Modifier
                    .padding(top = 130.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painterResource(id = R.drawable.routine), contentDescription = "none", Modifier.size(150.dp))
                Text(
                    text = "No Routines!",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
                Text(
                    text = "Click the '+' button below to get started",
                    modifier = Modifier
                        .padding(top = 10.dp, start = 40.dp, end = 40.dp),
                    textAlign = TextAlign.Center,
                )

                CustomFloatingActionButton("routines    ", navController = navController)

            }
        },
        bottomBar = { BottomBar(navController) }
    )
}

@Composable
fun RoutinesTopBar(){
    TopAppBar(
        title = {
        },
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xffffe400),
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

@Preview
@Composable
fun PreviewRoutinesTopBar(){
    MaterialTheme{
        Surface {
            RoutinesTopBar()
        }
    }
}


