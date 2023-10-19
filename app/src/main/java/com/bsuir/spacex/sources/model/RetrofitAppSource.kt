package com.bsuir.spacex.sources.model

import com.bsuir.spacex.app.model.Company
import com.bsuir.spacex.app.model.Launch
import com.bsuir.spacex.app.model.Launchpad
import com.bsuir.spacex.app.model.Ship
import com.bsuir.spacex.sources.backend.BackendRetrofitSource
import com.bsuir.spacex.sources.backend.RetrofitConfig
import kotlinx.coroutines.delay
import retrofit2.Response

class RetrofitAppSource(
    config: RetrofitConfig
) : BackendRetrofitSource(config), AppSource {

    private val appApi = retrofit.create(AppApi::class.java)

    override suspend fun getShip(id: String): Response<Ship> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getShip(id)
    }

    override suspend fun getAllShips(): Response<List<Ship>> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getAllShips()
    }

    override suspend fun getCompany(): Response<Company>  = wrapRetrofitExceptions {
        delay(1000)
        appApi.getCompany()
    }

    override suspend fun getLaunch(id: String): Response<Launch> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getLaunch(id)
    }

    override suspend fun getLaunchpad(id: String): Response<Launchpad> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getLaunchpad(id)
    }


}