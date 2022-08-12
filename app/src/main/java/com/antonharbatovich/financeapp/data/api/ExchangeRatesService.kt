package com.antonharbatovich.financeapp.data.api

import com.antonharbatovich.financeapp.BuildConfig.API_KEY
import com.antonharbatovich.financeapp.BuildConfig.BASE_URL
import com.antonharbatovich.financeapp.data.ExchangeRatesResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRatesService {

    @GET("latest")
   suspend fun getLatestCurrencies(
        @Query("base") base: String
    ): Response<ExchangeRatesResponse>
}

fun ExchangeRatesService(): ExchangeRatesService {

    val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("apikey", API_KEY)
                return@Interceptor chain.proceed(builder.build())
            }
        )
    }.build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ExchangeRatesService::class.java)
}
