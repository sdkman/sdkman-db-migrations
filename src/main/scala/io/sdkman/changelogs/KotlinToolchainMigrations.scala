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
      candidate = "kotlin-toolchain",
      name = "Kotlin Toolchain",
      description =
        "A set of tools for building and managing Kotlin projects, with a focus on user experience and tooling.",
      websiteUrl = "https://kotlin-toolchain.org",
      distribution = "UNIVERSAL"
    ).insert()
}
