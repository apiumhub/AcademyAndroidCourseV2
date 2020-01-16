package com.apiumhub.fakeserver

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

object FakeServer {
  fun start() {
    embeddedServer(Netty, 8080, module = Application::module).start()
  }
}

fun Application.module() {
  install(DefaultHeaders)
  install(CallLogging)
  install(ContentNegotiation) { gson {} }
  install(Routing) {
    get("/status") {
      call.respond(HttpStatusCode.OK, Test())
    }
    get("/timeline") {
      call.respond(
        HttpStatusCode.OK, listOf(
          Graznee("John", "Hello world!", System.currentTimeMillis()),
          Graznee("Alice", "This is my first graznee", System.currentTimeMillis()),
          Graznee("Jane", "Hello from Ktor!", System.currentTimeMillis())
        )
      )
    }
  }
}

data class Test(
  val hello: String = "Hello",
  val world: String = "World"
)

data class Graznee(
  val author: String,
  val body: String,
  val timestamp: Long
)