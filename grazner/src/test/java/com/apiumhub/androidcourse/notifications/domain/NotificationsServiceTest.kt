package com.apiumhub.androidcourse.notifications.domain

import com.apiumhub.androidcourse.notifications.domain.NotificationType.FAVORITE
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import java.util.concurrent.CountDownLatch

class NotificationsServiceTest {

  private val repository = mockk<NotificationsRepository>()
  private val sut = NotificationsService(repository)

  private val notificationsList = listOf(
    Notification("someId", "some body", FAVORITE)
  )

  @Test(timeout = 5000)
  fun `should execute onSuccess callback when notifications are loaded successfully from repository`() {
    val countDownLatch = CountDownLatch(1)

    every {
      repository.getNotifications()
    } returns notificationsList

    sut.getNotifications({
      countDownLatch.countDown()
      assertEquals(notificationsList, it)
    }, {
      fail()
    })

    countDownLatch.await()
  }

  @Test
  fun `should execute onError callback when there's an error loading notifications from repository`() {
    val countDownLatch = CountDownLatch(1)

    val networkException = NetworkException("There was an error loading notifications")
    every {
      repository.getNotifications()
    } throws networkException

    sut.getNotifications({
      fail()
    }, {
      countDownLatch.countDown()
      assertEquals(networkException, it)
    })

    countDownLatch.await()
  }
}