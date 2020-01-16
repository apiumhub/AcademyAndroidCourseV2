package com.apiumhub.androidcourse.timeline.data.network

import com.apiumhub.androidcourse.timeline.data.TimelineApi
import com.apiumhub.androidcourse.timeline.data.db.TimelineDatabase
import com.apiumhub.androidcourse.timeline.domain.Graznee
import com.apiumhub.androidcourse.timeline.domain.TimelineRepository

class NetworkAndDbTimelineRepository(
  private val api: TimelineApi,
  private val dbClient: TimelineDatabase
) : TimelineRepository {
  override suspend fun getTimeline(): List<Graznee> {
    return api.getTimeline()
        .map { Graznee(it.author, it.body, it.timestamp) }
  }
}