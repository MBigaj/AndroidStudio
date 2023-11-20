package com.example.lab4

import android.app.ActionBar
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shopping_list = ShoppingList()

        val table_list: TableLayout = findViewById(R.id.table_list)
        val add_item_button: View = findViewById(R.id.add_to_list)

        add_item_button.setOnClickListener { view ->
            val new_item = Item("name", shopping_list)

            val new_row = TableRow(this)
            new_row.id = new_item.id
            new_row.setBackgroundColor(Color.GRAY)
            new_row.layoutParams = ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT
            )

            val row = TextView(this)
            row.text = "HELLO" // set the text

            row.setTextColor(Color.WHITE)
            row.setPadding(5, 5, 5, 5)

            new_row.addView(row)

            table_list.addView(new_row)

            Snackbar.make(view, "Added new element to shopping list", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }
}

class ShoppingList()
{
    var item_list = arrayListOf<Item>()

    fun add_item(item: Item)
    {
        if (get_index(item.name) < 0)
            return

        this.item_list.add(item)

        item.id = this.item_list.size
    }

    fun remove_item(item: Item)
    {
        this.item_list.remove(item)
    }

    fun get_index(name: String): Int
    {
        for (i in 0..<this.item_list.size)
            if (this.item_list[i].name == name)
                return i
        return -1
    }
}

class Item(val name: String, val shopping_list: ShoppingList)
{
    var id: Int = 0

    init {
        shopping_list.add_item(this)
    }
}