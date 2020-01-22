package com.apiumhub.androidcourse.notifications.domain

import com.google.gson.annotations.SerializedName

data class Notification (
  val id: String,
  val body: String,
  val type: NotificationType
)

enum class NotificationType {
  @SerializedName("regraznee")
  REGRAZNEE,
  @SerializedName("favorite")
  FAVORITE
}