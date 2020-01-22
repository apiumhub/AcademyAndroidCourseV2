package com.apiumhub.androidcourse.timeline.domain

import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*

class TimelineServiceTest {

  private val repository = mockk<TimelineRepository>()
  private val sut = TimelineService(repository)

  @Test
  fun getTimeline() {
    TODO()
  }
}