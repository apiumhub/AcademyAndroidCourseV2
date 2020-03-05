package com.apiumhub.androidcourse.timeline.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apiumhub.androidcourse.timeline.domain.Graznee
import com.apiumhub.androidcourse.timeline.domain.TimelineService
import kotlinx.coroutines.launch

class TimelineViewModel(timelineService: TimelineService) : ViewModel() {

  private val grazneesPrivate: MutableLiveData<List<Graznee>> = MutableLiveData()
  val graznees: MutableLiveData<List<Graznee>> = grazneesPrivate

  private val errorsPrivate: MutableLiveData<Throwable> = MutableLiveData()
  val errors: LiveData<Throwable> = errorsPrivate

  init {
    viewModelScope.launch {
      runCatching {
        grazneesPrivate.postValue(timelineService.getTimeline())
      }.getOrElse {
        errorsPrivate.value = it
      }
    }
  }
}