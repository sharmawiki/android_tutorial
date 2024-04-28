package net.cogniverse.androidtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.cogniverse.androidtutorial.ui.theme.AndroidTutorialTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PirateCaptain()
                }
            }
        }
    }
}

@Composable
fun PirateCaptain(){
    val treasuresFound = remember {
        mutableStateOf(0)
    }
    val direction = remember {
        mutableStateOf("North")
    }
    val stormsEncountered = remember {
        mutableStateOf(0)
    }
    val storm = remember {
        mutableStateOf("Calm Sea!")
    }

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text("Current Direction: ${direction.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text("Treasures Found: ${treasuresFound.value}")
            Spacer(modifier = Modifier.width(16.dp))
            Text("Storms Encountered: ${stormsEncountered.value}")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Weather: ${storm.value}")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            direction.value = "North"
            if(Random.nextBoolean()){
                treasuresFound.value +=1
                storm.value = "Calm Sea"
            } else if(Random.nextBoolean()) {
                stormsEncountered.value += 1
                storm.value = "oh! Storm drowned us."
            } else {
                storm.value = "Calm Sea"
            }

        }) {
            Text("Sail North")
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Click to sail north.")
        }

        Row {
            Button(onClick = {
                direction.value = "West"
                if(Random.nextBoolean()){
                    treasuresFound.value +=1
                    storm.value = "Calm Sea"
                } else if(Random.nextBoolean()) {
                    stormsEncountered.value += 1
                    storm.value = "oh! Storm drowned us."
                } else {
                    storm.value = "Calm Sea"
                }

            }) {
                Text("Sail West")
                Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Click to sail west.")
            }
            Button(onClick = {
                direction.value = "East"
                if(Random.nextBoolean()){
                    treasuresFound.value +=1
                    storm.value = "Calm Sea"
                } else if(Random.nextBoolean()) {
                    stormsEncountered.value += 1
                    storm.value = "oh! Storm drowned us."
                } else {
                    storm.value = "Calm Sea"
                }
            }) {
                Text("Sail East")
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Click to sail east.")
            }
        }

        Button(onClick = {
            direction.value = "South"
            if(Random.nextBoolean()){
                treasuresFound.value +=1
                storm.value = "Calm Sea"
            } else if(Random.nextBoolean()) {
                stormsEncountered.value += 1
                storm.value = "oh! Storm drowned us."
            } else {
                storm.value = "Calm Sea"
            }

        }) {
            Text("Sail South")
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Click to sail south.")
        }
    }
}

@Preview
@Composable
fun PirateCaptainPreview(){
    PirateCaptain()
}