package com.apiumhub.androidcourse.timeline.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.apiumhub.androidcourse.R.layout
import kotlinx.android.synthetic.main.fragment_timeline.timelineRv
import org.koin.android.ext.android.inject

class TimelineFragment : Fragment() {

  private val timelineViewModel: TimelineViewModel by inject()
  private val adapter = TimelineAdapter()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(layout.fragment_timeline, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    timelineRv.adapter = adapter
    timelineRv.layoutManager = LinearLayoutManager(context)
    timelineViewModel.graznees.observe(this, Observer {
      adapter.grazneesList = it
      adapter.notifyDataSetChanged()
    })
  }
}