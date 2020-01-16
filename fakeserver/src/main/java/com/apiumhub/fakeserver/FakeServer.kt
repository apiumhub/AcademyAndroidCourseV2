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
import io.ktor.request.path
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.netty.util.internal.logging.InternalLoggerFactory
import io.netty.util.internal.logging.JdkLoggerFactory
import org.slf4j.event.Level
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.UUID
import kotlin.random.Random

private val loremGenerator = LoremIpsum.getInstance()

internal fun main() {
  FakeServer.start()
}

object FakeServer {
  fun start() {
    InternalLoggerFactory.setDefaultFactory(JdkLoggerFactory.INSTANCE)
    embeddedServer(Netty, 8080, module = Application::module).start()
  }
}

private fun Application.module() {
  install(DefaultHeaders)
  install(CallLogging) {
    level = Level.INFO
    filter { call -> call.request.path().startsWith("/timeline") }
  }
  install(ContentNegotiation) { gson() }
  install(Routing) {
    get("/status") {
      call.respond(HttpStatusCode.OK)
    }
    get("/timeline") {
      call.respond(
        HttpStatusCode.OK, listOf(
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
          Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
        )
      )
    }
  }
}

private data class Graznee(
  val id: String,
  val author: String,
  val body: String,
  val timestamp: String
)