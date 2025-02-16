package com.example.calculator

import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {

                app()

            }
        }
    }
}

@Composable
fun app(){
    var n1 by remember { mutableStateOf("") }
    var n2 by remember { mutableStateOf("") }
    var kq by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter
    ){
        Column {
            TextField(
                value = n1,
                onValueChange = {n1=it},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier.fillMaxWidth().padding(15.dp)
            )
            TextField(
                value = n2,
                onValueChange = {n2=it},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier.fillMaxWidth().padding(15.dp)
            )
            TextField(
                value = kq,
                onValueChange = {},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier.fillMaxWidth().padding(15.dp)
            )
            Row{
                Button(
                    onClick = {kq=(n1.toDouble() + n2.toDouble()).toString()},
                    Modifier.padding(5.dp)
                )
                {
                    Text(text="+")
                }
                Button(
                    onClick = {kq=(n1.toDouble() - n2.toDouble()).toString()},
                    Modifier.padding(5.dp)
                )
                {
                    Text(text="-")
                }
                Button(
                    onClick = {kq=(n1.toDouble() * n2.toDouble()).toString()},
                    Modifier.padding(5.dp)
                )
                {
                    Text(text="*")
                }
                Button(
                    onClick = {kq=(n1.toDouble() / n2.toDouble()).toString()},
                    Modifier.padding(5.dp)
                )
                {
                    Text(text="/")
                }
                Button(
                    onClick = {
                        n1=""
                        n2=""
                        kq=""
                    },
                    Modifier.padding(5.dp)
                )
                {
                    Text(text="Del")

                }
            }

        }
    }
}
