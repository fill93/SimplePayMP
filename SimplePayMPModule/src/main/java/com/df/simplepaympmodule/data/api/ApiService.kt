package com.df.simplepaympmodule.data.api

import com.df.simplepaympmodule.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    private var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(
            OkHttpClient.Builder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .callTimeout(40, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()
        )
        .addConverterFactory(MoshiConverterFactory.create()/*.asLenient()*/)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    val callApi: CallApi
        get() = retrofit.create(CallApi::class.java)

}