package com.apiumhub.androidcourse.timeline.domain

import com.apiumhub.androidcourse.timeline.data.db.GrazneeDbEntity
import com.apiumhub.androidcourse.timeline.data.network.GrazneeNetworkDto

data class Graznee(
  val author: String,
  val body: String,
  val timestamp: Long
) {
  constructor(networkModel: GrazneeNetworkDto) : this(
    author = networkModel.author,
    body = networkModel.body,
    timestamp = networkModel.timestamp
  )

  constructor(dbModel: GrazneeDbEntity) : this(
    author = dbModel.author,
    body = dbModel.body,
    timestamp = dbModel.timestamp
  )
}