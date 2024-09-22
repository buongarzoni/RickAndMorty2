package com.rickAndMorty.shared.model

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class FakeCharacters: Characters {
    override suspend fun getAll(): List<Character> {
        delay(5.seconds)
        return listOf(
            Character(
                name = "Pepe",
                status = "Alive",
                imageUrl = "www.google.com",
            ),
            Character(
                name = "Pepe 2",
                status = "dead",
                imageUrl = "www.google.com",
            ),
        )
    }
}
