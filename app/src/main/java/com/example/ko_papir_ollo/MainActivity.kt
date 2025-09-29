package com.example.ko_papir_ollo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {





    var sors1 by remember { mutableIntStateOf(1) }
    var sors2 by remember { mutableIntStateOf(1) }
    var gepPont by remember { mutableIntStateOf(0) }
    var jatekosPont by remember { mutableIntStateOf(0) }

    val backgroundColor = when {
        jatekosPont > gepPont -> Color.Green
        gepPont > jatekosPont -> Color.Red
        else -> Color.Gray
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(backgroundColor),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Játékszabályzat: Kő = 1 | Papír = 2 | Olló = 3")

        Spacer(modifier = Modifier.height(20.dp))

        // Kiírjuk a pontszámokat
        Text("Pontok: Gép: $gepPont | Játékos: $jatekosPont")

        Spacer(modifier = Modifier.height(20.dp))

        Text("Játék!")

        Text("$sors1")

        Button(onClick = {
            sors1 = Random.nextInt(1, 4)
            sors2 = 1
            val result = Ellenorzes(sors2, sors1)
            if (result.contains("Nyertél")) jatekosPont += 1
            if (result.contains("Vesztettél")) gepPont += 1
        }) {
            Text("Kő")
        }
        Text("$sors2")

        Button(onClick = {
            sors1 = Random.nextInt(1, 4)
            sors2 = 2
            val result = Ellenorzes(sors2, sors1)
            if (result.contains("Nyertél")) jatekosPont += 1
            if (result.contains("Vesztettél")) gepPont += 1
        }) {
            Text("Papír")
        }
        Text("$sors2")

        Button(onClick = {
            sors1 = Random.nextInt(1, 4)
            sors2 = 3
            val result = Ellenorzes(sors2, sors1)
            if (result.contains("Nyertél")) jatekosPont += 1
            if (result.contains("Vesztettél")) gepPont += 1
        }) {
            Text("Olló")
        }
        Text("$sors2")
    }
}

fun Ellenorzes(jatekos: Int, gep: Int): String {
    if (gep == 1 && jatekos == 2) {
        return "Nyertél! gép: kő | te: papír"
    } else if (gep == 1 && jatekos == 3) {
        return "Vesztettél! gép: kő | te: olló"
    } else if (gep == 1 && jatekos == 1) {
        return "Döntetlen! gép: kő | te: kő"
    } else if (gep == 2 && jatekos == 1) {
        return "Vesztettél! gép: papír | te: kő"
    } else if (gep == 2 && jatekos == 2) {
        return "Döntetlen! gép: papír | te: papír"
    } else if (gep == 2 && jatekos == 3) {
        return "Nyertél! gép: papír | te: olló"
    } else if (gep == 3 && jatekos == 3) {
        return "Döntetlen! gép: olló | te: olló"
    } else if (gep == 3 && jatekos == 2) {
        return "Vesztettél! gép: olló | te: papír"
    } else if (gep == 3 && jatekos == 1) {
        return "Nyertél! gép: olló | te: kő"
    }
    return ""
}


