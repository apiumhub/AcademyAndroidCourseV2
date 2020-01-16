package com.apiumhub.androidcourse.timeline.domain

class TimelineService(
  private val timelineRepository: TimelineRepository
) {
  suspend fun getTimeline(): List<Graznee> = timelineRepository.getTimeline()
}