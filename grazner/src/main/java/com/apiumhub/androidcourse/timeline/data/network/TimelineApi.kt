package com.apiumhub.androidcourse.timeline.data.network

import retrofit2.http.GET

interface TimelineApi {
    @GET("/timeline")
    suspend fun getTimeline(): List<GrazneeNetworkDto>
}