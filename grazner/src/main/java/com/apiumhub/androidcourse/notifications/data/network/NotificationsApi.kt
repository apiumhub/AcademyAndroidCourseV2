package com.apiumhub.androidcourse.notifications.data.network

import com.apiumhub.androidcourse.notifications.domain.Notification
import retrofit2.Call
import retrofit2.http.GET

interface NotificationsApi {
    @GET("/notifications")
    fun getNotifications(): Call<List<Notification>>//TODO Change me to coroutines
}