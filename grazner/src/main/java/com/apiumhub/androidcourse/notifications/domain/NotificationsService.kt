package com.apiumhub.androidcourse.notifications.domain

class NotificationsService(
  private val repository: NotificationsRepository
) {
  fun getNotifications(onNotificationsLoaded: (List<Notification>) -> Unit, onError: (Throwable) -> Unit) {
    Thread {
      runCatching {
        onNotificationsLoaded(repository.getNotifications())
      }.getOrElse(onError)
    }.start()
  }
}