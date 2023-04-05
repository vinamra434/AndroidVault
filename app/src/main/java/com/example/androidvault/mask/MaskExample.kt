package com.example.androidvault.mask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.androidvault.mask.components.MaskTransformation
import com.example.androidvault.mask.components.Masks

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