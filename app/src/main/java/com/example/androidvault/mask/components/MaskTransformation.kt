package com.example.androidvault.mask.components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class MaskTransformation(private val mask: String) : VisualTransformation {
    private val textMasker = TextMasker()

    override fun filter(text: AnnotatedString): TransformedText {
        val masked = textMasker.maskText(mask, text.text).orEmpty()

        val maskOffsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return masked.length
            }

            override fun transformedToOriginal(offset: Int): Int {
                return text.text.length
            }

        }

        return TransformedText(
            AnnotatedString(masked),
            maskOffsetMapping
        )
    }
}