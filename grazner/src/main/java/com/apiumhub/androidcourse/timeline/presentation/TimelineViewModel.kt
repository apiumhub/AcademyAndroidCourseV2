package com.apiumhub.androidcourse.timeline.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apiumhub.androidcourse.timeline.domain.TimelineService
import kotlinx.coroutines.launch

class TimelineViewModel(private val timelineService: TimelineService) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is timeline Fragment"
    }
    val text: LiveData<String> = _text

    init {
      viewModelScope.launch {
          timelineService.getTimeline()
      }
    }
}