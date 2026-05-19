package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "093")
class KotlinToolchainMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_kotlin_toolchain_candidate",
    author = "singleton11"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "kotlintoolchain",
      name = "Kotlin Toolchain",
      description =
        "The Kotlin Toolchain is a unified entry point into Kotlin with a focus on user experience and IDE support." +
          " It includes build tooling functionality as one of its core components. It can build plain JVM console " +
          "applications, Android and iOS mobile applications, server-side application like Spring or Ktor, " +
          "multiplatform projects that share business logic and/or UI, and more.",
      websiteUrl = "https://kotlin-toolchain.org",
      distribution = "UNIVERSAL"
    ).insert()

  @ChangeSet(
    order = "002",
    id = "002_add_kotlintoolchain_0_11_0",
    author = "singleton11"
  )
  def migration002(implicit db: MongoDatabase): Unit =
    Version(
      candidate = "kotlintoolchain",
      version = "0.11.0",
      url =
        "https://packages.jetbrains.team/maven/p/amper/amper/org/jetbrains/kotlin/kotlin-cli-sdkman/0.11.0/kotlin-cli-sdkman-0.11.0.zip"
    ).validate()
      .insert()
      .asCandidateDefault()
}
