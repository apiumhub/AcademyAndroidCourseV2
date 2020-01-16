package com.apiumhub.androidcourse.timeline.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TimelineDb.GRAZNEE_TABLE_NAME)

data class GrazneeDbEntity(
  @PrimaryKey
  val id: String,
  val author: String,
  val body: String,
  val timestamp: Long
)