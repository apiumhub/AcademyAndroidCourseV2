package com.apiumhub.fakeserver

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
  embeddedServer(
      Netty,
      port = 8080
  ) {
    this.install(ContentNegotiation) { gson {} }
    routing {
      get("/status") { call.respond(HttpStatusCode.OK, Test()) }
    }
  }.start()
}

data class Test(
  val hello: String = "Hello",
  val world: String = "World"
)