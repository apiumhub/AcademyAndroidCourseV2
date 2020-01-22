package com.apiumhub.androidcourse.notifications.data

import com.apiumhub.androidcourse.notifications.data.network.NotificationsApi
import org.junit.Test

import org.junit.Assert.*
import org.koin.test.KoinTest
import org.koin.test.inject

class NetworkNotificationsRepositoryIntegrationTest: KoinTest {

  private val api: NotificationsApi by inject()
  private val sut = NetworkNotificationsRepository(api)

  @Test
  fun getNotifications() {
    assertNotNull(sut.getNotifications())
  }
}