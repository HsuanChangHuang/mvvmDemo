package com.ray.mvvmdemo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.mvvmdemo.model.data.FlightModel

class ShareModel: ViewModel() {
    val listFilter = MutableLiveData<Boolean>()
    var flightItem = MutableLiveData<FlightModel.flightModelItem>()
}