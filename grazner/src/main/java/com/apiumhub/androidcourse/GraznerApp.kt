package com.apiumhub.androidcourse

import android.app.Application
import com.apiumhub.androidcourse.timeline.data.koinTimelineModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GraznerApp : Application() {

  private val koinModules = listOf(
      koinNetworkModule,
      koinDatabaseModule,
      koinTimelineModule
  )

  override fun onCreate() {
    super.onCreate()
    initializeKoin()
  }

  private fun initializeKoin() {
    startKoin {
      androidContext(this@GraznerApp)
      modules(koinModules)
    }
  }
}