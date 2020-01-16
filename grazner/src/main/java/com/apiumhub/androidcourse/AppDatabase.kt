package com.apiumhub.androidcourse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apiumhub.androidcourse.timeline.data.db.GrazneeDbEntity
import com.apiumhub.androidcourse.timeline.data.db.TimelineDao

@Database(
  entities = [GrazneeDbEntity::class],
  version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun timelineDao(): TimelineDao
}