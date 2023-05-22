package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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




class IdeasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStarterHomeTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    IdeasBody()
                }

            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun IdeasBody() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { IdeasTopBar()  },
        content = {
            Column(
                modifier = Modifier
                    .padding(top = 0.dp),
            ) {
                Text(
                    text = "More Recommendations",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 15.dp, end = 15.dp)
                )
                Text(
                    text = "Even more recommendations",
                    modifier = Modifier
                        .padding(top = 10.dp, start = 15.dp, end = 15.dp),
                )

                Image(
                    painterResource(id = R.drawable.background), contentDescription = "none",
                    alignment = Alignment.TopCenter,
                    modifier = Modifier.fillMaxSize()
                    .padding(top = 20.dp, start = 15.dp, end = 15.dp),)


            }
        },
        bottomBar = { BottomBar(navController) }
    )
}

@Composable
fun IdeasTopBar(){
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
    )
}

@Preview
@Composable
fun PreviewIdeasTopBar(){
    MaterialTheme{
        Surface {
            IdeasTopBar()
        }
    }
}


