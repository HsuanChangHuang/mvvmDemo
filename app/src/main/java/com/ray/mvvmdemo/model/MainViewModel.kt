package com.ray.mvvmdemo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.mvvmdemo.model.repository.MainRepository
import com.ray.mvvmdemo.model.data.FlightModel
import kotlinx.coroutines.*

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    val flightList = MutableLiveData<FlightModel>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun getAllFlights() {
        loading.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllFlights()
            // Switch to Android mainThread
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    flightList.postValue(response.body())
                } else {
                    errorMessage.postValue(response.message())
                }
                loading.postValue(false)
            }
        }
    }
}