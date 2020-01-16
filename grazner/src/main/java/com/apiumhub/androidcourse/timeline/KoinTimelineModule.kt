package com.apiumhub.androidcourse.timeline

import com.apiumhub.androidcourse.timeline.data.TimelineApi
import com.apiumhub.androidcourse.timeline.data.network.NetworkAndDbTimelineRepository
import com.apiumhub.androidcourse.timeline.domain.TimelineRepository
import com.apiumhub.androidcourse.timeline.domain.TimelineService
import com.apiumhub.androidcourse.timeline.presentation.TimelineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val koinTimelineModule = module {

  single {
    NetworkAndDbTimelineRepository(
      get<Retrofit>().create(TimelineApi::class.java),
      get()
    )
        as TimelineRepository
  }

  single { TimelineService(get()) }

  viewModel { TimelineViewModel(get()) }
}