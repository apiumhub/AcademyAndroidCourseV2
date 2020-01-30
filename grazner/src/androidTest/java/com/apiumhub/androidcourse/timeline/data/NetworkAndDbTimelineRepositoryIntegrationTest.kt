package com.apiumhub.androidcourse.timeline.data

import com.apiumhub.androidcourse.dbTestModule
import com.apiumhub.androidcourse.networkTestModule
import com.apiumhub.androidcourse.timeline.data.db.TimelineDao
import com.apiumhub.androidcourse.timeline.data.network.TimelineApi
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.test.KoinTest
import org.koin.test.inject

class NetworkAndDbTimelineRepositoryIntegrationTest : KoinTest {

  init {
    loadKoinModules(listOf(networkTestModule, dbTestModule))
  }

  private val dbClient: TimelineDao by inject()
  private val api: TimelineApi by inject()
  private val sut = NetworkAndDbTimelineRepository(api, dbClient)

  @Test
  fun getTimelineFromNetworkAndStoreInDb() {
    //TODO
  }

  @Test
  fun getTimelineFromDbIfNoNetworkConnection()  {
    //TODO
  }
}