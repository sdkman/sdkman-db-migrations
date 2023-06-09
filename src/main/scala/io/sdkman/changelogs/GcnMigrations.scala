package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "080")
class MicronautMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_gcn_candidate",
    author = "ezzarghili"
  )
  def migration001(implicit db: MongoDatabase): Candidate = {
    Candidate(
      candidate = "gcn",
      name = "Graal Cloud Native",
      description =
        "Graal Cloud Native (GCN) is a curated set of Micronaut(tm) framework modules designed from the ground up to be compiled ahead-of-time with GraalVM Native image resulting in native executables ideal for microservices." +
          "With GCN, You can build portable cloud-native Java microservices that start instantly and use fewer resources to reduce compute costs.",
      websiteUrl = "https://www.graal.cloud/gcn/"
    ).insert()
  }
}
