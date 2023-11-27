package com.example.lab5_task1


class RingsHolder {
    var rings = arrayListOf<Ring>()

    fun add_ring(ring: Ring)
    {
        ring.id = this.rings.size

        this.rings.add(ring)
    }

    fun clear_rings()
    {
        this.rings.clear()
    }
}

class Ring(val name: String, val description: String) {
    var id: Int = 0
}