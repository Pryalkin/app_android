package com.bsuir.spacex.sources.model

import com.bsuir.spacex.app.model.Company
import com.bsuir.spacex.app.model.Launch
import com.bsuir.spacex.app.model.Launchpad
import com.bsuir.spacex.app.model.Ship
import retrofit2.Response
import retrofit2.http.*

interface AppApi {

    @GET("v4/ships/{id}")
    suspend fun getShip(@Path("id") id: String): Response<Ship>

    @GET("v4/ships")
    suspend fun getAllShips(): Response<List<Ship>>

    @GET("v4/company")
    suspend fun getCompany(): Response<Company>

    @GET("v4/launches/{id}")
    suspend fun getLaunch(@Path("id") id: String): Response<Launch>

    @GET("v4/launchpads/{id}")
    suspend fun getLaunchpad(@Path("id") id: String): Response<Launchpad>

}