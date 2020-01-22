package com.apiumhub.androidcourse.notifications

import com.apiumhub.androidcourse.notifications.data.NetworkNotificationsRepository
import com.apiumhub.androidcourse.notifications.data.network.NotificationsApi
import com.apiumhub.androidcourse.notifications.domain.NotificationsRepository
import com.apiumhub.androidcourse.notifications.domain.NotificationsService
import com.apiumhub.androidcourse.notifications.presentation.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val koinNotificationsModule = module {
  single { get<Retrofit>().create(NotificationsApi::class.java) }

  single { NetworkNotificationsRepository(get()) as NotificationsRepository }

  single { NotificationsService(get()) }

  viewModel { NotificationsViewModel(get()) }
}