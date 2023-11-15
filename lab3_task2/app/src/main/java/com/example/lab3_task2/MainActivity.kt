package com.example.lab3_task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generate_button: Button = findViewById(R.id.generate)
        val display: TextView = findViewById(R.id.display)

        val customizer = JourneyCustomizer()

        generate_button.setOnClickListener {
            customizer.randomize_adventure()
            display.text = customizer.adventure
        }
    }
}