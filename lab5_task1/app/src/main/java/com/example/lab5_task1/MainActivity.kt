package com.example.lab5_task1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val three_rings_view: TextView = findViewById(R.id.three_rings)
        val seven_rings_view: TextView = findViewById(R.id.seven_rings)
        val nine_rings_view: TextView = findViewById(R.id.nine_rings)
        val final_ring_view: TextView = findViewById(R.id.final_ring)

        val ring_view_references = mapOf(
            three_rings_view to "three_rings_view",
            seven_rings_view to "seven_rings_view",
            nine_rings_view to "nine_rings_view",
            final_ring_view to "final_ring_view"
        )

        this.handle_rings_view(ring_view_references)
    }

    fun handle_rings_view(ring_views: Map<TextView, String>)
    {
        for (ring_view in ring_views) {
            ring_view.key.setOnClickListener {
                intent = Intent(this, RingsView::class.java)
                intent.putExtra("ring_view_ref", ring_view.value)
                startActivity(intent)
            }
        }
    }
}

