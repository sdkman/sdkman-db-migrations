package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "024")
class QuarkusMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_quarkus_candidate",
    author = "maxandersen"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "quarkus",
      name = "Quarkus",
      description =
        "Quarkus is a Kubernetes Native Java framework tailored for OpenJDK HotSpot and GraalVM, crafted from best-of-breed Java libraries and standards.",
      websiteUrl = "http://quarkus.io"
    ).insert()
}
