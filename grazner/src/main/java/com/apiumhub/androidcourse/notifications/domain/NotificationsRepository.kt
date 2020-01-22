package com.apiumhub.androidcourse.notifications.domain

interface NotificationsRepository {
  fun getNotifications(): List<Notification>
}