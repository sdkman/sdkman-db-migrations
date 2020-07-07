package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "031")
class Http4kMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_http4k_candidate",
    author = "daviddenton"
  )
  def migration001(implicit db: MongoDatabase) = {
    Candidate(
      candidate = "http4k",
      name = "http4k",
      description =
        "http4k is the Functional toolkit for building HTTP applications in Kotlin",
      websiteUrl = "http://http4k.org/"
    ).insert()
  }
}
