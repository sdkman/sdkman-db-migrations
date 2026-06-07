package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "095")
class KumlMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_kuml",
    author = "betschwa"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "kuml",
      name = "kUML",
      description =
        "kUML is a Kotlin-native DSL for UML 2, SysML 2, and C4 architecture modelling that compiles type-safe Kotlin sources to SVG diagrams through a configurable renderer pipeline.",
      websiteUrl = "https://kuml.dev",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()
}
