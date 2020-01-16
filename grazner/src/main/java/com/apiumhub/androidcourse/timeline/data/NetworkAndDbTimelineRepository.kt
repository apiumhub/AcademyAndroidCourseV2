package com.apiumhub.androidcourse.timeline.data

import com.apiumhub.androidcourse.timeline.data.db.TimelineDao
import com.apiumhub.androidcourse.timeline.data.network.TimelineApi
import com.apiumhub.androidcourse.timeline.domain.Graznee
import com.apiumhub.androidcourse.timeline.domain.TimelineRepository

class NetworkAndDbTimelineRepository(
  private val api: TimelineApi,
  private val dbClient: TimelineDao
) : TimelineRepository {
  override suspend fun getTimeline(): List<Graznee> =
    runCatching { api.getTimeline().map(::Graznee) }
      .getOrElse { dbClient.getAll().map(::Graznee) }
}