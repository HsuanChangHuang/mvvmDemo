package com.ray.mvvmdemo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ray.mvvmdemo.model.data.FlightModel

class ShareModel: ViewModel() {
    var flightItem = MutableLiveData<FlightModel.flightModelItem>()
}