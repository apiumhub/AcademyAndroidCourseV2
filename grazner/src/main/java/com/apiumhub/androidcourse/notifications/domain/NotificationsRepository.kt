package com.apiumhub.androidcourse.notifications.domain

interface NotificationsRepository {
  fun getNotifications(onNotificationsLoaded: (List<Notification>) -> Unit, onError: (Throwable) -> Unit)
}