package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "049")
class ZnaiMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_znai_candidate",
    author = "MykolaGolubyev"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "znai",
      name = "znai",
      description = "Build functional, maintainable, beautiful User Guides with znai. Instant pages navigation. " +
        "Local search. Multiple integrations to work with Python, Java, OpenAPI, etc. " +
        "Transform Getting Started sections into slideshow for your workshops. " +
        "Manage multiple documentations with self-deployed znai hub.",
      websiteUrl = "https://github.com/testingisdocumenting/znai"
    ).insert()
}
