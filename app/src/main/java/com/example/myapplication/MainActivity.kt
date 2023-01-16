package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)) {
                        Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var hehe by remember { mutableStateOf(4) }
    val mContext = LocalContext.current
    var hehebool = false
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(60.dp)
        ) {
            Button(onClick = {
                if(hehe < 8){
                    hehe += 1
                } else {
                    Toast.makeText(mContext, "Maximum 8 letters",Toast.LENGTH_LONG).show()
                }
            }) {
                Text(text = "+")
            }
            Button(onClick = { hehe += 1
                hehe -= 1
                hehebool = !hehebool
            }) {
                Text(text = "GENERATE")
            }
            Button(onClick = {
                if (hehe > 2){
                    hehe -= 1
                } else {
                    Toast.makeText(mContext, "Minimum 2 letters",Toast.LENGTH_LONG).show()
                }
            }) {
                Text(text = "-")
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            val cLetter = arrayListOf(66, 67, 68, 70, 71, 72, 74, 75, 76, 77, 78, 80, 81, 82, 83, 84, 86, 87, 88, 90)
            val vLetter = arrayListOf(65, 69, 73, 79, 85, 89)

            items(hehe) { it ->
                TextBox(if (hehebool){
                    if (it % 2 == 1){
                        cLetter.random()
                    } else {
                        vLetter.random()
                    }
                } else {
                    if (it % 2 == 1){
                        vLetter.random()
                    } else {
                        cLetter.random()
                    }
                })
            }
        }
    }
}

@Composable
fun TextBox(hehe: Int) {
//    var text by remember {
//        mutableStateOf(TextFieldValue(""))
//    }
//    TextField(
//        modifier = Modifier.background(Color.White)
//            .width(60.dp)
//            .height(60.dp),
//
//        value = text,
//        onValueChange = {newText ->
//            text = newText
//        },
//        textStyle = TextStyle.Default.copy(fontSize = 50.sp)
//    )
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(63.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 8.dp,
                    bottomEnd = 8.dp
                )
            )
            .border(
                1.dp,
                Color(
                    red = 1f,
                    green = 0.6083333492279053f,
                    blue = 0.6083333492279053f,
                    alpha = 1f
                ),
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 8.dp,
                    bottomEnd = 8.dp
                )
            )
            .background(
                Color(
                    red = 0.2874999940395355f,
                    green = 0.02156248688697815f,
                    blue = 0.08898322284221649f,
                    alpha = 1f
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
            Text(text = "${hehe.toChar()}", fontSize = 40.sp)
        }
//        var text by remember { mutableStateOf(TextFieldValue(""))}
//            TextField(value = text, onValueChange ={newText ->  text = newText
//       },textStyle = TextStyle.Default.copy(fontSize = 20.sp))
        }
    }
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting()
    }
}