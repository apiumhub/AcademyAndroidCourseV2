package com.apiumhub.androidcourse.notifications.data

import com.apiumhub.androidcourse.notifications.data.network.NotificationsApi
import com.apiumhub.androidcourse.notifications.domain.NetworkException
import com.apiumhub.androidcourse.notifications.domain.Notification
import com.apiumhub.androidcourse.notifications.domain.NotificationsRepository

class NetworkNotificationsRepository(
  private val api: NotificationsApi
) : NotificationsRepository {

  override fun getNotifications(): List<Notification> {
    val response = api.getNotifications().execute()
    if (response.isSuccessful) {
      response.body()?.let {
        return it
      } ?: throw NetworkException("There was an error loading notifications")
    }
    else {
      throw NetworkException("There was an error loading notifications")
    }
  }
}