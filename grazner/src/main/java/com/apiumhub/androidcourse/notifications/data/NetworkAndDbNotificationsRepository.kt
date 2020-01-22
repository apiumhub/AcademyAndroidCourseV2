package com.apiumhub.androidcourse.notifications.data

import com.apiumhub.androidcourse.notifications.data.network.NotificationsApi
import com.apiumhub.androidcourse.notifications.domain.Notification
import com.apiumhub.androidcourse.notifications.domain.NotificationsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkNotificationsRepository(
  private val api: NotificationsApi
) : NotificationsRepository {
  override fun getNotifications(onNotificationsLoaded: (List<Notification>) -> Unit, onError: (Throwable) -> Unit) {
      api.getNotifications().enqueue(object: Callback<List<Notification>> {
        override fun onFailure(call: Call<List<Notification>>, t: Throwable) {
          onError(t)
        }

        override fun onResponse(call: Call<List<Notification>>, response: Response<List<Notification>>) {
          if (response.isSuccessful)
            response.body()?.let(onNotificationsLoaded) ?: onError(Error("No body on response"))
          else
            onError(Error("Some error when fetching notifications"))
        }
      })
  }
}