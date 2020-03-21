package com.apiumhub.androidcourse.timeline.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class TimelineServiceTest {
  private val repository = mockk<TimelineRepository>()
  private val sut = TimelineService(repository)

  @Test
  fun getTimeline() = runBlockingTest {
    Dispatchers.setMain()
    coEvery {

    }
    coVerify {

    }
//    TODO()
  }
}
