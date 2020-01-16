package com.apiumhub.androidcourse.timeline.domain

class TimelineService(
  timelineNetworkRepository: TimelineRepository,
  timelineDatabaseRepository: TimelineRepository
) {
  suspend fun getTimeline(): List<Graznee> {
    TODO()
  }
}