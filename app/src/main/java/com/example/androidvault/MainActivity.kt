package com.example.androidvault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidvault.mask.MaskTransformation
import com.example.androidvault.mask.Masks
import com.example.androidvault.ui.theme.AndroidVaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidVaultTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MaskExample()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidVaultTheme {
        Greeting("Android")
    }
}

@Composable
fun MaskExample() {

    var phoneNumber by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var date by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var postalCode by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Column(modifier = Modifier.padding(20.dp)) {
        TextField(
            value = phoneNumber,
            visualTransformation = MaskTransformation(Masks.PHONE_MASK),
            onValueChange = {
                if (it.text.count() <= 10) {
                    phoneNumber = it
                }
            },
            label = { Text(text = "Phone number") },
            placeholder = { Text(text = "Phone number") },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = date,
            visualTransformation = MaskTransformation(Masks.DATE_MASK),
            onValueChange = {
                if (it.text.count() <= 8) {
                    date = it
                }
            },
            label = { Text(text = "Date") },
            placeholder = { Text(text = "Date") },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = postalCode,
            visualTransformation = MaskTransformation(Masks.POSTAL_CODE_MASK),
            onValueChange = {
                if (it.text.count() <= 6) {
                    postalCode = it
                }
            },
            label = { Text(text = "Postal code") },
            placeholder = { Text(text = "Postal code") },
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}