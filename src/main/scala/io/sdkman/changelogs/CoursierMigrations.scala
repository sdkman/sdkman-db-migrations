package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "076")
class CoursierMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_coursier_candidate",
    author = "lwronski"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "coursier",
      name = "Coursier",
      description =
        "Coursier is the Scala application and artifact manager. It can install Scala applications and setup your Scala development environment. It can also download and cache artifacts from the web.",
      websiteUrl = "https://get-coursier.io"
    ).insert()
}
