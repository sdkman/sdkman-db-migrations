package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "083")
class JikkouMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_jikkou_candidate",
    author = "fhussonnois"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "jikkou",
      name = "Jikkou",
      description =
        "Jikkou is a command-line client for efficient management, automation and provisioning of resources for Kafka, Schema Registry, etc. " +
          "Inspired by kubectl and the Kubernetes resource definition files, it offers an intuitive, user-friendly approach to configuration management.",
      websiteUrl = "https://streamthoughts.github.io/jikkou/"
    ).insert()
}
