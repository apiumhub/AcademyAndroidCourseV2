package com.apiumhub.androidcourse.timeline.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

object TimelineDb {
  const val GRAZNEE_TABLE_NAME = "graznees"
}

@Dao
interface TimelineDao {

  @Insert
  suspend fun insertAll(items: List<GrazneeDbEntity>)

  @Query("SELECT * FROM ${TimelineDb.GRAZNEE_TABLE_NAME}")
  suspend fun getAll(): List<GrazneeDbEntity>

  @Query("SELECT * FROM ${TimelineDb.GRAZNEE_TABLE_NAME} WHERE id == :grazneeId")
  suspend fun getById(grazneeId: String): GrazneeDbEntity
}