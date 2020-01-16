package com.apiumhub.androidcourse.timeline.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.apiumhub.androidcourse.R.layout
import com.apiumhub.androidcourse.timeline.domain.Graznee
import com.apiumhub.androidcourse.timeline.presentation.TimelineAdapter.GrazneeViewHolder
import kotlinx.android.synthetic.main.graznee_layout.view.authorNameTv
import kotlinx.android.synthetic.main.graznee_layout.view.grazneeBodyTv
import kotlinx.android.synthetic.main.graznee_layout.view.timestampTv
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle.SHORT

class TimelineAdapter : RecyclerView.Adapter<GrazneeViewHolder>() {

  var grazneesList = emptyList<Graznee>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    GrazneeViewHolder(LayoutInflater.from(parent.context).inflate(layout.graznee_layout, parent, false))

  override fun getItemCount(): Int = grazneesList.size

  override fun onBindViewHolder(holder: GrazneeViewHolder, position: Int) {
    holder.bind(grazneesList[position])
  }

  class GrazneeViewHolder(itemView: View) : ViewHolder(itemView) {
    fun bind(item: Graznee) {
      itemView.authorNameTv.text = item.author
      itemView.grazneeBodyTv.text = item.body
      itemView.timestampTv.text = LocalDateTime.parse(item.timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME).format(DateTimeFormatter.ofLocalizedDateTime(SHORT))
    }
  }
}