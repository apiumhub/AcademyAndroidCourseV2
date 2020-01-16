package com.apiumhub.androidcourse.timeline.data

import retrofit2.http.GET

interface TimelineApi {
    @GET("/timeline")
    suspend fun getTimeline(): List<GrazneeDataDto>
}