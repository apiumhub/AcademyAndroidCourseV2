package com.apiumhub.androidcourse.notifications.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apiumhub.androidcourse.notifications.domain.Notification
import com.apiumhub.androidcourse.notifications.domain.NotificationsService

class NotificationsViewModel(notificationsService: NotificationsService) : ViewModel() {

  private val notificationsPrivate: MutableLiveData<List<Notification>> = MutableLiveData()
  val notifications: LiveData<List<Notification>> = notificationsPrivate

  private val errorsPrivate: MutableLiveData<Throwable> = MutableLiveData()
  val errors: LiveData<Throwable> = errorsPrivate

  init {
    notificationsService.getNotifications({
      //Need to use postValue as this runs on a background thread
      notificationsPrivate.postValue(it)
    }, {
      errorsPrivate.postValue(it)
    })
  }
}