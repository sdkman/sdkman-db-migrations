package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "064")
class KcctlMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_kcctl_candidate",
    author = "gunnarmorling"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "kcctl",
      name = "kcctl",
      description =
        "A modern and intuitive command-line client for Kafka Connect. Relying on the idioms and semantics of kubectl, it allows you to register and examine connectors, delete them, restart them, etc.",
      websiteUrl = "https://github.com/kcctl/kcctl"
    ).insert()
}
