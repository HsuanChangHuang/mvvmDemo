package com.ray.mvvmdemo

import android.util.Log
import com.ray.mvvmdemo.model.data.FlightModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("v3/launches")
    suspend fun getAllFlights(): Response<FlightModel>

    companion object {
        private const val url = "https://api.spacexdata.com/"
        private val logging : HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                Log.i(
                    "interceptor msg",
                    message
                )
            })
        private val okHttpClient : OkHttpClient
        private val retrofit: Retrofit
        private val retrofitService: RetrofitService

        init {
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient = OkHttpClient().newBuilder().addInterceptor(logging).build()
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            retrofitService = retrofit.create(RetrofitService::class.java)
        }

        fun getInstance() : RetrofitService {
            return retrofitService
        }
    }
}