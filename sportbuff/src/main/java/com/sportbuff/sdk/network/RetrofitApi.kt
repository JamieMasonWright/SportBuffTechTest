package com.sportbuff.sdk.network

import com.sportbuff.sdk.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    private var retrofit: Retrofit? = null

    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                val httpClient = OkHttpClient.Builder()
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                httpClient.addInterceptor(logging)

                retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}