package com.example.lab4

import android.app.ActionBar
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shopping_list = ShoppingList()

        val table_list: TableLayout = findViewById(R.id.table_list)
        val add_item_button: View = findViewById(R.id.add_to_list)
        val share_button: View = findViewById(R.id.share_button)

        add_item_button.setOnClickListener { view ->
            this.setup_builder(view, table_list, shopping_list)
        }

        share_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)

            val name_list = arrayListOf<String>()

            for (item in shopping_list.item_list)
                name_list.add(item.name)

            val message = name_list.joinToString(", ")

            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(Intent.createChooser(intent, "Share using"))
        }
    }

    fun setup_builder(view: View, table_list: TableLayout, shopping_list: ShoppingList)
    {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)

        val inflater: LayoutInflater = layoutInflater
        val dialogLayout: View = inflater.inflate(R.layout.edit_popup, null)
        val editText: EditText = dialogLayout.findViewById(R.id.add_item_to_list)

        with(builder) {
            setTitle("Add new Item")
            setPositiveButton("Add") { dialog, which ->
                if (shopping_list.get_index(editText.text.toString()) == -1) {

                    val new_item = Item(shopping_list)

                    new_item.set_name(editText.text.toString())

                    setup_new_row(table_list, new_item)

                    Toast.makeText(
                        this@MainActivity,
                        "Added ${new_item.name} to shopping list",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "${editText.text} already exists on list",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            setNegativeButton("Cancel") { dialog, which ->
                Log.d("Main", "Negative btn clicked")
            }

            setView(dialogLayout)
            show()
        }
    }

    fun setup_new_row(table_list: TableLayout, new_item: Item)
    {
        val new_row = TableRow(this)
        new_row.id = new_item.id

        new_row.setBackgroundColor(Color.GRAY)
        new_row.layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.WRAP_CONTENT
        )

        val row = TextView(this)

        row.text = new_item.name

        row.setTextColor(Color.WHITE)
        row.setPadding(5, 5, 5, 5)

        new_row.addView(row)

        table_list.addView(new_row)

        new_row.setOnClickListener {
            new_item.shopping_list.remove_item(new_item)
            table_list.removeView(new_row)
        }
    }
}