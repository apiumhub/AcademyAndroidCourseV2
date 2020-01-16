package com.apiumhub.androidcourse.timeline.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apiumhub.androidcourse.timeline.domain.Graznee
import com.apiumhub.androidcourse.timeline.domain.TimelineService
import kotlinx.coroutines.launch

class TimelineViewModel(private val timelineService: TimelineService) : ViewModel() {

  private val grazneesPrivate: MutableLiveData<List<Graznee>> = MutableLiveData()
  val graznees: LiveData<List<Graznee>> = grazneesPrivate

  init {
    viewModelScope.launch {
      grazneesPrivate.postValue(timelineService.getTimeline())
    }
  }
}