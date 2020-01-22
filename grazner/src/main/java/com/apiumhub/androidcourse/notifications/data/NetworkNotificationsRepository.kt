package com.apiumhub.androidcourse.notifications.data

import com.apiumhub.androidcourse.notifications.data.network.NotificationsApi
import com.apiumhub.androidcourse.notifications.domain.Notification
import com.apiumhub.androidcourse.notifications.domain.NotificationsRepository

class NetworkNotificationsRepository(
  private val api: NotificationsApi
) : NotificationsRepository {

  override fun getNotifications(onNotificationsLoaded: (List<Notification>) -> Unit, onError: (Throwable) -> Unit) {
    val response = api.getNotifications().execute()
    if (response.isSuccessful) {
      response.body()?.let {
        onNotificationsLoaded(it)
      } ?: onError(Error("There was an error loading notifications"))
    }
    else {
      onError(Error("There was an error loading notifications"))
    }

  }
}