package com.apiumhub.androidcourse.notifications.data

import com.apiumhub.androidcourse.notifications.data.network.NotificationsApi
import com.apiumhub.androidcourse.notifications.domain.NetworkException
import com.apiumhub.androidcourse.notifications.domain.Notification
import com.apiumhub.androidcourse.notifications.domain.NotificationType.FAVORITE
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Assert.fail
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.CountDownLatch

class NetworkNotificationsRepositoryTest {

  private val notificationsList = listOf(
    Notification("someId", "someBody", FAVORITE)
  )

  private val notificationsApi = mockk<NotificationsApi>()
  private val sut = NetworkNotificationsRepository(notificationsApi)

  @Test
  fun `getNotifications should execute onSuccess callback when api returns success`() {
    every {
      notificationsApi.getNotifications()
    } returns MockCall.buildSuccess(notificationsList)

    val notifications = sut.getNotifications()

    assertEquals(notificationsList, notifications)
  }

  @Test
  fun `getNotifications should execute onError callback when api fails`() {
    every {
      notificationsApi.getNotifications()
    } returns MockCall.buildHttpError(500, "text/plain", "Unknown server error")

    runCatching {
      sut.getNotifications()
      fail()
    }.getOrElse {
      assert(it is NetworkException)
    }
  }
}

private class MockCall<T>(private val response: Response<T>) : Call<T> {

  companion object {
    inline fun <reified T> buildSuccess(body: T): Call<T> {
      return MockCall(Response.success(body))
    }

    inline fun <reified T> buildHttpError(errorCode: Int, contentType: String, content: String): Call<T> {
      return MockCall(Response.error(errorCode, ResponseBody.create(contentType.toMediaTypeOrNull(), content)))
    }
  }

  override fun execute(): Response<T> = response

  override fun enqueue(callback: Callback<T>?) {}

  override fun isExecuted(): Boolean = false

  override fun clone(): Call<T> = this

  override fun isCanceled(): Boolean = false

  override fun cancel() {}

  override fun request(): Request? = null
}