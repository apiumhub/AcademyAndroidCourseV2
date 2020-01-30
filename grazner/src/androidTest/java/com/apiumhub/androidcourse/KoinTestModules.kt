package com.apiumhub.androidcourse

import androidx.room.Room
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkTestModule = module(override = true) {
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

val dbTestModule = module(override = true) {
  single {
    Room
      .inMemoryDatabaseBuilder(get(), AppDatabase::class.java)
      .fallbackToDestructiveMigration()
      .build()
  }
}