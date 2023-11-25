package com.example.lab4

class ShoppingList()
{
    var item_list = arrayListOf<Item>()

    fun add_item(item: Item)
    {
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

class Item(val shopping_list: ShoppingList)
{
    var name: String = ""
    var id: Int = 0

    init {
        this.shopping_list.add_item(this)
    }

    fun set_name(name: String)
    {
        this.name = name
    }
}