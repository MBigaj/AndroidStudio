package com.example.lab5_task1

import android.app.ActionBar
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class RingsView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rings_view)

        val ring_reference = intent.getStringExtra("ring_view_ref")

        val ring_holder = RingsHolder()

        val ring_views = mapOf(
            "three_rings_view" to {
                ring_holder.add_ring(
                    Ring(
                        "Narya",
                        "Narya, also named the Ring of Fire or Red Ring, was one of the Three Rings.\n" +
                        "\n" +
                        "According to Unfinished Tales, at the start of the War of the Elves and Sauron, Celebrimbor gave Narya to Círdan, Lord of the Havens of Mithlond, who kept it after Gil-galad's death."
                    )
                )
                ring_holder.add_ring(
                    Ring(
                        "Nenya",
                        "Nenya, also named as the Ring of Water, the White Ring and the Ring of Adamant, was one of the Three Rings. The name is derived from the Quenya Nén meaning water.\n" +
                        "\n" +
                        "Nenya was described as being made of mithril and set with a \"white stone\", presumably a diamond (this is never stated explicitly, although the usage of the word \"adamant\", an old synonym, is strongly suggestive). The ring was wielded by Galadriel of Lothlórien."
                    )
                )
                ring_holder.add_ring(
                    Ring(
                        "Vilya",
                        "Vilya, the Ring of Air, Blue Ring, the Dominant Ring, or Ring of Sapphire was the greatest of the Three Rings.\n" +
                        "\n" +
                        "When Sauron laid waste to Eregion, Vilya, along with Narya, was sent to the Elven-King Gil-galad far away in Lindon."
                    )
                )
            },
            "seven_rings_view" to {
                ring_holder.add_ring(
                    Ring(
                        "The Seven Rings",
                        "Sauron presented the Seven Rings to the Dwarf-lords. This might have been the division of seven Dwarf clans mentioned in The History of Middle-earth: Durin's Folk, Firebeards, Broadbeams, Ironfists, Stiffbeards, Blacklocks, and Stonefoots."
                    )
                )
            },
            "nine_rings_view" to {
                ring_holder.add_ring(
                    Ring(
                    "The Nine Rings",
                    "The nine rings for mortal men were those divided amongst those men doomed to become the Nazgûl, the Ringwraiths. These ring-bearers held rings that were controlled by Sauron, for they became evil servants of his."
                    )
                )
            },
            "final_ring_view" to {
                ring_holder.add_ring(
                    Ring(
                        "The One to Rule Them All",
                        "The One Ring, secretly forged by Sauron in the heart of Mount Doom, had the power to dominate the other nineteen Great Rings. Sauron's intent was to command the minds of the other ring bearers through their rings of power."
                    )
                )
            },
        )

        val ring_table: TableLayout = findViewById(R.id.rings_table)

        ring_views.get(ring_reference)?.invoke()

        for (ring in ring_holder.rings) {
            this.setup_new_row(ring_table, ring)
        }
    }

    fun setup_new_row(table_list: TableLayout, ring: Ring)
    {
        val new_row = TableRow(this)
        new_row.id = ring.id

        new_row.setBackgroundColor(Color.GRAY)
        new_row.layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.WRAP_CONTENT
        )

        val row = TextView(this)

        row.text = ring.name

        row.setTextSize(30f)

        row.setTextColor(Color.WHITE)
        row.setPadding(5, 5, 5, 5)

        new_row.addView(row)

        table_list.addView(new_row)

        this.display_ring_description()
    }

    fun display_ring_description()
    {
    }
}