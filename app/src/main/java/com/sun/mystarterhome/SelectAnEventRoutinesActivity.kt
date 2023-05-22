package com.sun.mystarterhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sun.mystarterhome.ui.theme.MyStarterHomeTheme




class SelectAnEventRoutinesActivity : ComponentActivity() {

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
                    SelectAnEventRoutinesBody(navController)
                }

            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectAnEventRoutinesBody(navController: NavHostController) {

    Scaffold(
        topBar = { SelectAnEventRoutinesTopBar(navController, showBackButton = true)  },
        content = {
            Column {
                MyListView(navController)
            }
        },
    )
}

@Composable
fun SelectAnEventRoutinesTopBar(navController: NavHostController, showBackButton: Boolean = false){
    TopAppBar(
        title = {
            Text(
                text = "Select an Event",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
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
    )
}



@Composable
fun MyListView(navController: NavHostController) {
    val time = "Time"
    val location = "Location"

    Column {
        ListItem(text = createStyledText("$time is Time"), onClick = {
            navController.navigate(NavRoutes.CreateRoutinesTime.route)
        })
        Divider()
        ListItem(text = createStyledText("It's sunset at $location"), onClick =  {

        })
        Divider()
        ListItem(text = createStyledText("It's sunrise at $location"), onClick = {

        })
        Divider()
        ListItem(text = createStyledText("It's 15 minutes before sunrise at $location"), onClick = {

        })
        Divider()
        ListItem(text = createStyledText("It's 15 minutes before sunset at $location"), onClick = {

        })
        Divider()
        ListItem(text = createStyledText("It's 15 minutes after sunset at $location"), onClick = {

        })
        Divider()
    }
}

@Composable
fun ListItem(text: AnnotatedString,  onClick: () -> Unit) {
    Text(text = text, modifier = Modifier
        .padding( start = 20.dp, bottom = 18.dp, end = 20.dp, top = 18.dp)
        .clickable(onClick = onClick),
    )
}

fun createStyledText(text: String): AnnotatedString {
    val builder = AnnotatedString.Builder()

    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)

    // Find the occurrences of "Location" and "15" in the text and apply the bold style
    val locationIndex = text.indexOf("Location")
    val fifteenIndex = text.indexOf("15")

    builder.append(text)

    if (locationIndex != -1) {
        builder.addStyle(boldStyle, locationIndex, locationIndex + "Location".length)
    }

    if (fifteenIndex != -1) {
        builder.addStyle(boldStyle, fifteenIndex, fifteenIndex + "15".length)
    }

    return builder.toAnnotatedString()
}
