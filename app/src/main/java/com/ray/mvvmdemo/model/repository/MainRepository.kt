package com.ray.mvvmdemo.model.repository

import com.ray.mvvmdemo.utils.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllFlights() = retrofitService.getAllFlights()
}