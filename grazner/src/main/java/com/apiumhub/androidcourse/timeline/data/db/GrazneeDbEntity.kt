package com.apiumhub.androidcourse.timeline.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.apiumhub.androidcourse.timeline.data.network.GrazneeNetworkDto

@Entity(tableName = TimelineDb.GRAZNEE_TABLE_NAME)

data class GrazneeDbEntity(
  @PrimaryKey
  val id: String,
  val author: String,
  val body: String,
  val timestamp: String
) {
  constructor(networkDto: GrazneeNetworkDto) : this(
    networkDto.id,
    networkDto.author,
    networkDto.body,
    networkDto.timestamp
  )
}