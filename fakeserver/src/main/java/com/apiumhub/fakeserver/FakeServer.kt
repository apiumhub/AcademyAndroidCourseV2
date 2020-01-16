package com.apiumhub.fakeserver

import com.thedeanda.lorem.LoremIpsum
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
import java.util.UUID

private val loremGenerator = LoremIpsum.getInstance()

object FakeServer {
  fun start() {
    embeddedServer(Netty, 8080, module = Application::module).start()
  }
}

fun Application.module() {
  install(DefaultHeaders)
  install(CallLogging)
  install(ContentNegotiation) { gson() }
  install(Routing) {
    get("/status") {
      call.respond(HttpStatusCode.OK, Test())
    }
    get("/timeline") {
      call.respond(
        HttpStatusCode.OK, listOf(
          Graznee(UUID.randomUUID().toString(), "John", loremGenerator.getWords(20), System.currentTimeMillis()),
          Graznee(UUID.randomUUID().toString(), "Alice", loremGenerator.getWords(5), System.currentTimeMillis()),
          Graznee(UUID.randomUUID().toString(), "Jane", loremGenerator.getWords(15), System.currentTimeMillis())
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
  val id: String,
  val author: String,
  val body: String,
  val timestamp: Long
)