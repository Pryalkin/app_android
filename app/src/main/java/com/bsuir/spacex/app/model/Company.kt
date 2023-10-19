package com.bsuir.spacex.app.model

data class Company(
    val id: String,
    val summary: String,
    val headquarters: Headquarters,
    val name: String,
    val founder: String
)
