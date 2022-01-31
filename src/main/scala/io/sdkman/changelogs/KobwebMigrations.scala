package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "068")
class KobwebMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_kobweb_candidate",
    author = "bitspittle"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "kobweb",
      name = "Kobweb",
      description =
        "Kobweb is an opinionated Kotlin web framework built on top of Compose for Web. The CLI provides commands to help setup and manage your project.",
      websiteUrl = "https://kobweb.varabyte.com",
      distribution = "UNIVERSAL"
    ).insert()
}
