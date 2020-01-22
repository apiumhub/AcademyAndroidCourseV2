package com.apiumhub.androidcourse.notifications.domain

class NotificationsService(
  private val repository: NotificationsRepository
) {
  fun getNotifications() {
    repository.getNotifications()
  }
}