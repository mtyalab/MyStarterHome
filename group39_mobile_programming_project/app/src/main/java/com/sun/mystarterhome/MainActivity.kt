package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
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
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sun.mystarterhome.ui.theme.MyStarterHomeTheme
import androidx.navigation.compose.rememberNavController



val greyColor = Color(0xfff5f5f5)

sealed class NavRoutes(val route: String) {
    object Favorite : NavRoutes("favorites")
    object Things : NavRoutes("things")
    object Routine : NavRoutes("routines")
    object Ideas : NavRoutes("ideas")
    object Settings : NavRoutes("settings")
    object SelectRoutines : NavRoutes("select_routines")
    object CreateRoutines : NavRoutes("create_routines")
    object SelectEvents : NavRoutes("select_events")
    object CreateRoutinesTime : NavRoutes("create_routines_time")
    object CreateRoutinesNotification : NavRoutes("create_routines_notification")
    object SelectThingTime : NavRoutes("select_time")
    object SelectActionTime : NavRoutes("select_action")

}


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStarterHomeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomBar(navController) }
                ) {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppBody(navController: NavHostController) {
    TopNavigationBar()

    Column(
        modifier = Modifier
            .padding(top = 130.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painterResource(id = R.drawable.star),
            contentDescription = "none",
            Modifier.size(150.dp)
        )
        Text(
            text = "No favorites!",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 20.dp)
        )
        Text(
            text = "Add your favorite routines for easy access here",
            modifier = Modifier
                .padding(top = 10.dp, start = 40.dp, end = 40.dp),
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Tap the '+' button below to add your favorite routines",
            modifier = Modifier
                .padding(top = 10.dp, start = 40.dp, end = 40.dp),
            textAlign = TextAlign.Center,
        )
        CustomFloatingActionButton("favorites", navController)
    }
}




@Composable
fun TopNavigationBar(){
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
                    Icons.Default.Edit,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewTopNavigationBar(){
    MaterialTheme{
        Surface {
            TopNavigationBar()
        }
    }
}


@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomBar(navController: NavHostController) {

    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(backgroundColor = greyColor, elevation = 10.dp) {
        BottomNavigationItem(icon = {
            Image(painterResource(id = R.drawable.star), contentDescription = "none", Modifier.size(24.dp))
        },
           label = {Text(text="Favorites")},
            unselectedContentColor =  Color(0xff000000),
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
                if (selectedIndex.value == 0) {
                    navController.navigate("favorites") {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

            })
        BottomNavigationItem(icon = {
            Image(painterResource(id = R.drawable.things), contentDescription = "none", Modifier.size(24.dp))
        },
            label = {Text(text="Things")},
            unselectedContentColor =  Color(0xff000000),
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
                if (selectedIndex.value == 1) {
                    navController.navigate(NavRoutes.Things.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }


            })
        BottomNavigationItem(icon = {
            Image(painterResource(id = R.drawable.routine), contentDescription = "none", Modifier.size(24.dp))
        },
            label = {Text(text="Routines")},
            unselectedContentColor =  Color(0xff000000),
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
                if (selectedIndex.value == 2) {
                    navController.navigate(NavRoutes.Routine.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

            })
        BottomNavigationItem(icon = {
            Image(painterResource(id = R.drawable.idea), contentDescription = "none", Modifier.size(24.dp))
        },
            label = {Text(text="Ideas")},
            unselectedContentColor =  Color(0xff000000),
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
if (selectedIndex.value == 3) {
    navController.navigate(NavRoutes.Ideas.route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}


            })
        BottomNavigationItem(icon = {
            Image(painterResource(id = R.drawable.settings), contentDescription = "none", Modifier.size(24.dp))
        },
            label = {Text(text="Settings")},
            unselectedContentColor =  Color(0xff000000),
            selected = (selectedIndex.value == 4),
            onClick = {
                selectedIndex.value = 4
                if(selectedIndex.value == 4) {
                    navController.navigate(NavRoutes.Settings.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            })
    }
}



@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.Favorite.route) {
        composable(NavRoutes.Favorite.route) {
            AppBody(navController)
        }
        composable(NavRoutes.Things.route) {
           ThingsBody()
        }
        composable(NavRoutes.Routine.route) {
            RoutinesBody()
        }
        composable(NavRoutes.Ideas.route) {
            IdeasBody()
        }

        composable(NavRoutes.Settings.route) {
            SettingsBody()
        }

        composable(NavRoutes.SelectRoutines.route) {
            SelectRoutinesBody(navController)
        }

        composable(NavRoutes.CreateRoutines.route) {
            CreateRoutinesBody(navController)
        }

        composable(NavRoutes.SelectEvents.route) {
            SelectAnEventRoutinesBody(navController)
        }

        composable(NavRoutes.CreateRoutinesTime.route) {
            CreateRoutinesTimeBody(navController)
        }

        composable(NavRoutes.SelectThingTime.route) {
            SelectThingBody(navController)
        }

        composable(NavRoutes.SelectActionTime.route) {
            SelectAnActionBody(navController)
        }

        composable(NavRoutes.CreateRoutinesNotification.route) {
            CreateRoutinesNotificationBody(navController)
        }

    }
}


@Composable
fun CustomFloatingActionButton(screen: String, navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            backgroundColor = Color(0xff0099d5),
            contentColor = Color(0xffffffff),
            modifier = Modifier
                .padding(bottom = 80.dp, end = 15.dp)
                .align(alignment = Alignment.BottomEnd),
            onClick = {

              if (screen == "favorites") {
                     navController.navigate(NavRoutes.SelectRoutines.route)
              }
            }
        ) {
            Icon(imageVector = Icons.Filled.Add, tint = Color.White, contentDescription = "Add")
        }
    }
}