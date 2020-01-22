package com.apiumhub.androidcourse.timeline.data

import com.apiumhub.androidcourse.timeline.data.db.TimelineDao
import com.apiumhub.androidcourse.timeline.data.network.TimelineApi
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*

class NetworkAndDbTimelineRepositoryTest {

  private val dbClient = mockk<TimelineDao>()
  private val api = mockk<TimelineApi>()
  private val sut = NetworkAndDbTimelineRepository(api, dbClient)

  @Test
  fun getTimeline() {
    TODO()
  }
}