package com.apiumhub.androidcourse.timeline

import com.apiumhub.androidcourse.timeline.data.TimelineApi
import com.apiumhub.androidcourse.timeline.data.db.TimelineDatabaseRepository
import com.apiumhub.androidcourse.timeline.data.network.TimelineNetworkRepository
import com.apiumhub.androidcourse.timeline.domain.TimelineService
import com.apiumhub.androidcourse.timeline.presentation.TimelineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val koinTimelineModule = module {
  single(named("TimelineNetwork")) { TimelineNetworkRepository(get<Retrofit>().create(TimelineApi::class.java)) }
  single(named("TimelineDb")) { TimelineDatabaseRepository() }

  single { TimelineService(get(named("TimelineNetwork")), get(named("TimelineDb"))) }

  viewModel { TimelineViewModel(get()) }
}