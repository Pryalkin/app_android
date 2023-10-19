package com.bsuir.spacex.app.repository

import com.bsuir.spacex.app.model.Company
import com.bsuir.spacex.app.model.Launch
import com.bsuir.spacex.app.model.Launchpad
import com.bsuir.spacex.app.model.Ship
import com.bsuir.spacex.sources.exception.BackendException
import com.bsuir.spacex.sources.exception.InvalidCredentialsException
import com.bsuir.spacex.sources.model.AppSource
import retrofit2.Response

class AppRepository(
    private val appSource: AppSource
) {

    suspend fun getShip(s: String): Response<Ship> {
        val res: Response<Ship> = try {
            appSource.getShip(s)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }

    suspend fun getAllShips(): Response<List<Ship>> {
        val res: Response<List<Ship>> = try {
            appSource.getAllShips()
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }

    suspend fun getCompany(): Response<Company> {
        val res: Response<Company> = try {
            appSource.getCompany()
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }

    suspend fun getLaunch(id: String): Response<Launch> {
        val res: Response<Launch> = try {
            appSource.getLaunch(id)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }

    suspend fun getLaunchpad(id: String): Response<Launchpad> {
        val res: Response<Launchpad> = try {
            appSource.getLaunchpad(id)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }


}