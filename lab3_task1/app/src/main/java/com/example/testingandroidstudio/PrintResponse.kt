package com.example.testingandroidstudio

import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PrintResponse : AppCompatActivity() {
    companion object {
        const val MESSAGE = "message"
        const val CIPHERED_MESSAGE = "ciphered_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print_response)

        val message_view: TextView = findViewById(R.id.regular_message)
        val ciphered_message_view: TextView = findViewById(R.id.ciphered_message_print)
        val message_switch: Switch = findViewById(R.id.message_switch)

        val message = intent.getStringExtra(MESSAGE)
        val ciphered_message = intent.getStringExtra(CIPHERED_MESSAGE)

        message_view.text = message
        ciphered_message_view.text = ciphered_message

        message_switch.setOnClickListener() {
            var switch_state: Boolean = message_switch.isChecked

            if (switch_state)
                message_view.visibility = View.INVISIBLE
            else
                message_view.visibility = View.VISIBLE
        }
    }
}