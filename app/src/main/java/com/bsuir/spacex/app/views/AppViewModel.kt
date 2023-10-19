package com.bsuir.spacex.app.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsuir.spacex.app.utils.MutableLiveEvent
import com.bsuir.spacex.app.utils.publishEvent
import com.bsuir.spacex.app.utils.share
import com.bsuir.spacex.Singletons
import com.bsuir.spacex.app.model.Company
import com.bsuir.spacex.app.model.Launch
import com.bsuir.spacex.app.model.Launchpad
import com.bsuir.spacex.app.model.Ship
import com.bsuir.spacex.app.model.utils.HttpResponse
import com.bsuir.spacex.app.repository.AppRepository
import com.google.gson.GsonBuilder
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class AppViewModel  (
    private val appRepository: AppRepository = Singletons.appRepository
): ViewModel() {

    private val _message = MutableLiveEvent<String>()
    val message = _message.share()

    private val _ships = MutableLiveData<List<Ship>>()
    val ships: LiveData<List<Ship>> get() = _ships

    private val _company = MutableLiveData<Company>()
    val company: LiveData<Company> get() = _company

    private val _launch = MutableLiveData<Launch>()
    val launch: LiveData<Launch> get() = _launch

    private val _launchpad = MutableLiveData<Launchpad>()
    val launchpad: LiveData<Launchpad> get() = _launchpad

    private fun showToast(mes: String) = _message.publishEvent(mes)

    fun getAllShip(){
        viewModelScope.launch {
            var res: Response<List<Ship>> = appRepository.getAllShips()
            if (res.isSuccessful){
                _ships.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

    fun getCompany() {
        viewModelScope.launch {
            var res: Response<Company> = appRepository.getCompany()
            if (res.isSuccessful){
                _company.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

    fun getLaunch(id: String) {
        viewModelScope.launch {
            var res: Response<Launch> = appRepository.getLaunch(id)
            if (res.isSuccessful){
                _launch.value = res.body()
                getLaunchpad(_launch.value!!.launchpad)
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

    private fun getLaunchpad(id: String) {
        viewModelScope.launch {
            var res: Response<Launchpad> = appRepository.getLaunchpad(id)
            if (res.isSuccessful){
                _launchpad.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

}