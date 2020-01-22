package com.apiumhub.androidcourse

import android.app.Application
import com.apiumhub.androidcourse.notifications.koinNotificationsModule
import com.apiumhub.androidcourse.timeline.koinTimelineModule
import com.apiumhub.fakeserver.FakeServer
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GraznerApp : Application() {

  private val koinModules = listOf(
    koinNetworkModule,
    koinDatabaseModule,
    koinTimelineModule,
    koinNotificationsModule
  )

  override fun onCreate() {
    super.onCreate()
    initializeKoin()
    startFakeServer()
  }

  private fun initializeKoin() {
    startKoin {
      androidContext(this@GraznerApp)
      modules(koinModules)
    }
  }

  private fun startFakeServer() {
    AndroidThreeTen.init(this)
    FakeServer.start()
  }
}