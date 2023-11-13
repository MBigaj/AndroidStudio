package com.example.testingandroidstudio

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.testingandroidstudio.databinding.ActivityPrintResponseBinding

class PrintResponse : AppCompatActivity() {
    companion object {
        const val MESSAGE = "message"
        const val CIPHERED_MESSAGE = "ciphered_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print_response)

        val message_view = findViewById<TextView>(R.id.regular_message)
        val ciphered_message_view = findViewById<TextView>(R.id.ciphered_message_print)

        val message = intent.getStringExtra(MESSAGE)
        val ciphered_message = intent.getStringExtra(CIPHERED_MESSAGE)

        message_view.text = message
        ciphered_message_view.text = ciphered_message
    }
}