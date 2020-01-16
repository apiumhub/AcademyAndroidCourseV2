package com.apiumhub.androidcourse.timeline

import com.apiumhub.androidcourse.AppDatabase
import com.apiumhub.androidcourse.timeline.data.NetworkAndDbTimelineRepository
import com.apiumhub.androidcourse.timeline.data.network.TimelineApi
import com.apiumhub.androidcourse.timeline.domain.TimelineRepository
import com.apiumhub.androidcourse.timeline.domain.TimelineService
import com.apiumhub.androidcourse.timeline.presentation.TimelineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val koinTimelineModule = module {

  single { get<Retrofit>().create(TimelineApi::class.java) }
  single { get<AppDatabase>().timelineDao() }

  single { NetworkAndDbTimelineRepository(get(), get()) as TimelineRepository }

  single { TimelineService(get()) }

  viewModel { TimelineViewModel(get()) }
}