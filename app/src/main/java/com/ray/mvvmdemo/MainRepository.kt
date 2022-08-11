package com.ray.mvvmdemo

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllFlights() = retrofitService.getAllFlights()
}