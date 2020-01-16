package com.apiumhub.androidcourse

import androidx.room.Room
import com.apiumhub.androidcourse.timeline.data.db.TimelineDao
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val koinNetworkModule = module {

  single {
    OkHttpClient.Builder().addInterceptor(
      HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
      })
      .build()
  }

  single {
    Retrofit
      .Builder()
      .baseUrl("http://localhost:8080")
      .client(get())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }
}

val koinDatabaseModule = module {
  single {
    Room
      .databaseBuilder(get(), AppDatabase::class.java, "grazner_db")
      .fallbackToDestructiveMigration()
      .build()
  }
}