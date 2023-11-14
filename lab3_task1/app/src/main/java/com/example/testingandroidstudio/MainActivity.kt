package com.example.testingandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name_input: TextView = findViewById(R.id.text_input)
        val cipher_list: Spinner = findViewById(R.id.cipher_types_list)

        var message: CharSequence = ""

        val cipher = Cipher()

        val find_holiday_button: Button = findViewById(R.id.finder)
        find_holiday_button.setOnClickListener {
            message = name_input.text
            cipher.set_message(message)

            var selected_cipher = cipher_list.selectedItem as String
            cipher.cipher_resolve(selected_cipher)

            val intent = Intent(this, PrintResponse::class.java)
            intent.putExtra(PrintResponse.MESSAGE, cipher.message.toString())
            intent.putExtra(PrintResponse.CIPHERED_MESSAGE, cipher.ciphered_message)
            startActivity(intent)
        }
    }
}
