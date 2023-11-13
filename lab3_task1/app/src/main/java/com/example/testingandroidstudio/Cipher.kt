package com.example.testingandroidstudio

class Cipher()
{
    var message: CharSequence = ""
    var ciphered_message: String = ""

    val cipher_resolver = mapOf(
        "Ceasar Cipher" to { this.caesar_cipher() },
        "Cipher 2" to { this.cipher2() },
        "Cipher 3" to { this.cipher3() }
    )

    fun set_message(message: CharSequence)
    {
        this.message = message
    }

    fun cipher_resolve(option: String): Any?
    {
        return this.cipher_resolver.get(option)?.invoke()
    }

    fun caesar_cipher()
    {
        var cipher: String = ""

        for (character in this.message)
        {
            if (character < 'A' || (character > 'Z' && character < 'a') || character > 'z')
                continue

            val new_char = character + 3

            if (new_char > 'Z' && new_char < 'a')
                cipher += character - ('Z' - 'A') + 2
            else if (new_char > 'z')
                cipher += character - ('z' - 'a') + 2
            else
                cipher += new_char
        }

        this.ciphered_message = cipher
    }

    fun cipher2()
    {

    }

    fun cipher3()
    {

    }
}