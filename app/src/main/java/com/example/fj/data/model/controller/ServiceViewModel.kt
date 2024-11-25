package com.example.fj.data.model.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fj.data.model.ServiceModel
import com.example.fj.network.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Response

class ServiceViewModel: ViewModel() {
    private val api = RetrofitClient.api

    fun getServices(onResult: (Response<List<ServiceModel>>) -> Unit){
        viewModelScope.launch {
            try {
                val response = api.getServices()
                onResult(response)
            } catch (exception:Exception){
                print(exception)
            }
        }
    }

    fun showService(id: Int, onResult: (Response<ServiceModel>) -> Unit){
        viewModelScope.launch {
            try {
                val response = api.getService(id)
                onResult(response)
            } catch (exception:Exception){
                print(exception)
            }
        }
    }

    fun createService(service: ServiceModel, onResult: (Response<ServiceModel>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.createService(service)
                onResult(response)
            } catch (exception:Exception){
                print(exception)
            }
        }
    }

    fun updateService(id: Int, service: ServiceModel, onResult: (Response<ServiceModel>) -> Unit) {
        try {
            viewModelScope.launch {
                val response = api.updateService(id, service)
                onResult(response)
            }
        } catch (exception:Exception){
            print(exception)
        }
    }

    fun deleteService(id: Int, onResult: (Response<ServiceModel>) -> Unit) {
        try {
            viewModelScope.launch {
                val response = api.deleteService(id)
                onResult(response)
            }
        } catch (exception:Exception){
            print(exception)
        }
    }
}