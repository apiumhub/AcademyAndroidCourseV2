package com.apiumhub.androidcourse.timeline.domain

interface TimelineRepository {
    suspend fun getTimeline(): List<Graznee>
}