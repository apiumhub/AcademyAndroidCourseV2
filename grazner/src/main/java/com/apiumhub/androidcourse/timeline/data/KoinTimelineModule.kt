package com.apiumhub.androidcourse.timeline.data

import com.apiumhub.androidcourse.timeline.data.db.TimelineDatabaseRepository
import com.apiumhub.androidcourse.timeline.data.network.TimelineNetworkRepository
import com.apiumhub.androidcourse.timeline.domain.TimelineService
import org.koin.dsl.module
import retrofit2.Retrofit

val koinTimelineModule = module {
  single { TimelineNetworkRepository(get<Retrofit>().create(TimelineApi::class.java)) }
  single { TimelineDatabaseRepository() }
  single { TimelineService(get(), get()) }
}