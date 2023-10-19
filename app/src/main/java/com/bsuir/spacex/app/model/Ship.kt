package com.bsuir.spacex.app.model

data class Ship(
    val id: String,
    val name: String,
    val type: String,
    val launches: Array<String>?
)
