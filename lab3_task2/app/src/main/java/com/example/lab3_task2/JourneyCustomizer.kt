package com.example.lab3_task2

import kotlin.random.Random

class JourneyCustomizer
{
    val dice_size: Int = 20
    var adventure = ""

    val journeys = mapOf(
        1 to "The Boglands",
        2 to "Tattooine",
        3 to "Mars",
        4 to "Jupyter",
        5 to "The Moon",
        6 to "The Kingdom of Fire",
        7 to "The Kingdom of Water",
        8 to "The Kingdom of Earth",
        9 to "The Kingdom of Ice",
        10 to "The Kingdom of Lava",
        11 to "The Basement",
        12 to "The Holy Kingdom",
        13 to "The Fairy land",
        14 to "The Crypt",
        15 to "The Mausoleum",
        16 to "The Graveyard",
        17 to "The Bar",
        18 to "The Stables",
        19 to "Your own house",
        20 to "Your mates house"
    )

    val adventurers = mapOf(
        1 to "Sauron",
        2 to "Bilbo Baggins",
        3 to "Luke Skywalker",
        4 to "Deadpool",
        5 to "Princess Leia",
        6 to "Anakin Skywalker",
        7 to "Your crush",
        8 to "Joji",
        9 to "Your favourite actor",
        10 to "Lego Yoda",
        11 to "Baby Yoda",
        12 to "Lee Sin",
        13 to "A Salamander",
        14 to "Batman",
        15 to "Asterix",
        16 to "Spiderman",
        17 to "Godrick the Grafted",
        18 to "Malenia, Blade of Michaela",
        19 to "Thor, the God of Thunder",
        20 to "Fenrir"
    )

    fun randomize_adventure()
    {
        this.adventure = "During your adventure to "

        this.adventure += this.get_random_journey()

        this.adventure += ", you meet "

        this.adventure += this.get_random_adventurer()
    }

    fun get_random_journey(): String?
    {
        val option = Random.nextInt(1, this.dice_size)
        return this.journeys.get(option)
    }

    fun get_random_adventurer(): String?
    {
        val option = Random.nextInt(1, this.dice_size)
        return this.adventurers.get(option)
    }
}