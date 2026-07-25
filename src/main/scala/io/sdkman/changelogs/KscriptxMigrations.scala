package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "096")
class KscriptxMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_kscriptx_candidate",
    author = "ybznek"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "kscriptx",
      name = "kscriptx",
      description =
        "kscriptx is Kotlin scripting with kscript feature parity: Coursier dependencies, " +
          "GraalVM native kotlinc for fast compiles, content-addressed caching, and an optional " +
          "persistent JVM daemon for near-instant warm runs.",
      websiteUrl = "https://github.com/ybznek/kscriptx",
      distribution = "UNIVERSAL"
    ).insert()
}
