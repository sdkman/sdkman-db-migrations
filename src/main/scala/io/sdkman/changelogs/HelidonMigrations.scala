package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase
import org.bson.Document

@ChangeLog(order = "077")
class HelidonMigrations {

  @ChangeSet(
    order = "001",
    id = "001-add_helidon_candidate",
    author = "Helidon Project"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "helidon",
      name = "Helidon CLI",
      description =
        "The Helidon CLI lets you easily create a Helidon project by picking from a set of archetypes. " +
        "It also supports a developer loop that performs continuous compilation and application restart, " +
        "so you can easily iterate over source code changes.",
      websiteUrl = "https://helidon.io"
    ).insert()
}
