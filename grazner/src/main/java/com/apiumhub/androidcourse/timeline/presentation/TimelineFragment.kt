package com.apiumhub.androidcourse.timeline.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.apiumhub.androidcourse.R
import org.koin.android.ext.android.inject

class TimelineFragment : Fragment() {

  private val timelineViewModel: TimelineViewModel by inject()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
    val textView: TextView = root.findViewById(R.id.text_dashboard)
    timelineViewModel.text.observe(this, Observer {
      textView.text = it
    })
    return root
  }
}