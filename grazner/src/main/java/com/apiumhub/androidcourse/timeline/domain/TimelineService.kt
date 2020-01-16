package com.apiumhub.androidcourse.timeline.domain

class TimelineService(
  private val timelineNetworkRepository: TimelineRepository,
  private val timelineDatabaseRepository: TimelineRepository
) {
  suspend fun getTimeline(): List<Graznee> {
    return timelineNetworkRepository.getTimeline()
  }
}