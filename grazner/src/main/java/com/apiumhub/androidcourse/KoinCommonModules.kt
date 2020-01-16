package com.apiumhub.androidcourse

import org.koin.dsl.module
import retrofit2.Retrofit

val koinNetworkModule =  module {
  single {
    Retrofit
      .Builder()
      .baseUrl("http://localhost:8080")
      .build()
  }
}

val koinDatabaseModule = module {

}