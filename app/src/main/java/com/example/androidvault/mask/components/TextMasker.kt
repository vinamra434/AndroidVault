package com.example.androidvault.mask.components

class TextMasker {
    companion object {
        fun removeMask(text: String?): String? {
            return text?.replace("[.\\-/() +]".toRegex(), "")
        }

        fun getMaskTokenCount(text: String): Int {
            return text.length - removeMask(text)!!.length
        }
    }

    fun maskText(mask: String, text: String?): String? {
        if (text.isNullOrEmpty()) return text
        var maskedText = ""
        var textCharIndex = 0
        val maskCharacters = mask.toCharArray()
        val maskLength = maskCharacters.size
        for (maskCharIndex in 0 until maskLength) {
            val maskCharacter = maskCharacters[maskCharIndex]
            if (maskCharacter == '#') {
                maskedText += text[textCharIndex]
                textCharIndex++
                if (textCharIndex >= text.length) {
                    break
                }
            } else {
                maskedText += maskCharacter
            }
        }
        return maskedText
    }


}