package com.example.gesture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gesture.ui.theme.GestureTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   // PointerEvents()
                    Tap()
                }
            }
        }
    }
}


@Composable

fun PointerEvents() {

    var msg by remember { mutableStateOf("作者：張綺庭") }

    Column {
        Text("\n" + msg)
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            msg = "${event.type}, ${event.changes.first().position}"
                        }

                    }

                }

        )

    }

}

@Composable

fun Tap() {

    var msg by remember { mutableStateOf("TAP相關手勢實例") }

    Column {

        Text("\n" + msg)

        Image(

            painter = painterResource(id = R.drawable.pu0),

            contentDescription = "靜宜之美",

            modifier = Modifier

                .fillMaxSize()

        )

    }

}