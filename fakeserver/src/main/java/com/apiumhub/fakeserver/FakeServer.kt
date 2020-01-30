package com.apiumhub.fakeserver

import com.thedeanda.lorem.LoremIpsum
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.netty.util.internal.logging.InternalLoggerFactory
import io.netty.util.internal.logging.JdkLoggerFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
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
  install(ContentNegotiation) { gson() }
  install(Routing) {
    get("/status") {
      call.respond(HttpStatusCode.OK)
    }

    get("/notifications") {
      call.respond(HttpStatusCode.OK, notificationsList)
    }

    get("/timeline") {
      call.respond(HttpStatusCode.OK, grazneesList)
    }

    get("/search/graznees") {
      when (call.request.queryParameters["q"]) {
        "invalidQuery" -> call.respond(Companion.BadRequest, "Invalid query string")
        "empty" -> call.respond(Companion.OK, "[]")
        else -> call.respond(Companion.OK, grazneesList)
      }
    }

    get("/search/users") {
      when (call.request.queryParameters["q"]) {
        "invalidQuery" -> call.respond(Companion.BadRequest, "Invalid query string")
        "empty" -> call.respond(Companion.OK, "[]")
        else -> call.respond(Companion.OK, usersList)
      }
    }

    get("/graznee/{grazneeId}/regraznee") {
      when (call.parameters["grazneeId"]) {
        "invalidGraznee" -> call.respond(HttpStatusCode.BadRequest, "Invalid graznee ID")
        else -> call.respond(HttpStatusCode.OK)
      }
    }

//    get("/user/profile/{userId}") {
//      when (call.parameters["userId"]) {
//        "invalidUserId" -> call.respond(HttpStatusCode.BadRequest, "Invalid user ID")
//        else -> call.respond(HttpStatusCode.OK, TODO())
//      }
//    }
//
//    get("/user/me") {
//      call.respond(Companion.OK, TODO())
//    }
//
//    post("/graznee/new") {
//      val graznee = call.receive<InputGraznee>()
//      call.respond(Companion.OK, Graznee(UUID.randomUUID().toString(), ))
//
//    }
//
//    post {"/login"} {
//
//    }
  }
}

private val grazneesList
  get() = listOf(
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME)),
    Graznee(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), LocalDateTime.now().format(ISO_LOCAL_DATE_TIME))
  )

private val notificationsList
  get() = listOf(
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} marked your graznee as favorite!", "favorite"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} marked your graznee as favorite!", "favorite"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} marked your graznee as favorite!", "favorite"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} marked your graznee as favorite!", "favorite"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} marked your graznee as favorite!", "favorite"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} marked your graznee as favorite!", "favorite"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} marked your graznee as favorite!", "favorite"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee"),
    Notification(UUID.randomUUID().toString(), "${loremGenerator.getWords(2)} Regrazned you!", "regraznee")
  )

private val usersList
  get() = listOf(
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15)),
    User(UUID.randomUUID().toString(), loremGenerator.getWords(2), loremGenerator.getWords(Random.nextInt(5, 20)), "https://api.adorable.io/avatars/${Random.nextInt(0, 100)}", grazneesList.subList(0, 15))
  )

private data class InputGraznee(
  val body: String
)

private data class Graznee(
  val id: String,
  val author: String,
  val body: String,
  val timestamp: String
)

private data class Notification(
  val id: String,
  val body: String,
  val type: String
)

private data class User(
  val id: String,
  val userName: String,
  val bio: String,
  val avatar: String,
  val lastGraznees: List<Graznee>
)