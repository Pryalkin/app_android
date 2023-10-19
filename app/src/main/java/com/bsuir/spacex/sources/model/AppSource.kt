package com.bsuir.spacex.sources.model

import com.bsuir.spacex.app.model.Company
import com.bsuir.spacex.app.model.Launch
import com.bsuir.spacex.app.model.Launchpad
import com.bsuir.spacex.app.model.Ship
import retrofit2.Response

interface AppSource {
    suspend fun getShip(id: String): Response<Ship>
    suspend fun getAllShips(): Response<List<Ship>>
    suspend fun getCompany(): Response<Company>
    suspend fun getLaunch(id: String): Response<Launch>
    suspend fun getLaunchpad(id: String): Response<Launchpad>
}