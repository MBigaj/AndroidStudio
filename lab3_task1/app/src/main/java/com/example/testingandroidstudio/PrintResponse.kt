package com.example.testingandroidstudio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
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
        val share_button: ImageView = findViewById(R.id.share_button)

        var switch_state: Boolean = message_switch.isChecked

        val message = intent.getStringExtra(MESSAGE)
        val ciphered_message = intent.getStringExtra(CIPHERED_MESSAGE)

        message_view.text = message
        ciphered_message_view.text = ciphered_message

        message_switch.setOnClickListener() {
            switch_state = message_switch.isChecked

            if (switch_state)
                message_view.visibility = View.INVISIBLE
            else
                message_view.visibility = View.VISIBLE
        }

        share_button.setOnClickListener() {
            val intent: Intent = Intent(Intent.ACTION_SEND)
            switch_state = message_switch.isChecked

            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, message)

            if (switch_state)
                intent.putExtra(Intent.EXTRA_TEXT, ciphered_message)

            startActivity(Intent.createChooser(intent, "Share using"))
        }
    }
}