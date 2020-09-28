package com.sportbuff.sdk.network

import com.sportbuff.sdk.entities.BuffsEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface   SportBuffApi {
    @GET("buffs/{buffId}")
    suspend fun getBuffs(
        @Path("buffId") buffId: Int
    ): BuffsEntity
}
