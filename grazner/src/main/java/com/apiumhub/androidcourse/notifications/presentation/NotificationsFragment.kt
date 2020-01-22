package com.apiumhub.androidcourse.notifications.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.apiumhub.androidcourse.R
import org.koin.android.ext.android.inject

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

  private val notificationsViewModel: NotificationsViewModel by inject()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    notificationsViewModel.notifications.observe({ lifecycle }) {
      Log.d("Notifications", "Notifications Loaded! $it")
    }

    notificationsViewModel.errors.observe({ lifecycle }) {
      Log.e("Notifications", "Error loading notifications $it")
    }
  }

}