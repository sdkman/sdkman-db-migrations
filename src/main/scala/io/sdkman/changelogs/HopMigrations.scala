package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "097")
class HopMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_hop_candidate",
    author = "rmannibucau"
  )
  def migration001(implicit db: MongoDatabase): Candidate =
    Candidate(
      candidate = "hop",
      name = "Hop",
      description =
        "Apache Hop is a data orchestration and data engineering platform.",
      websiteUrl = "https://hop.apache.org/",
      distribution = "UNIVERSAL"
    ).insert()
}
