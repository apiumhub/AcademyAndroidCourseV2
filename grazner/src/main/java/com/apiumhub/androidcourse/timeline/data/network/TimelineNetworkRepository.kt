package com.apiumhub.androidcourse.timeline.data.network

import com.apiumhub.androidcourse.timeline.data.TimelineApi
import com.apiumhub.androidcourse.timeline.domain.Graznee
import com.apiumhub.androidcourse.timeline.domain.TimelineRepository
import com.apiumhub.androidcourse.timeline.domain.TimelineService

class TimelineNetworkRepository(
    private val api: TimelineApi
): TimelineRepository {
    override suspend fun getTimeline(): List<Graznee> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}