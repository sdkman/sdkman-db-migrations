package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "043")
class PomcheckerMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_pomchecker_candidate",
    author = "aalmiray"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "pomchecker",
      name = "Pomchecker",
      description =
        "Pomchecker - Checks that POM files comply with the minimum rules required for publication to Maven Central. It can also check if a POM is a valid BOM file.",
      websiteUrl = "https://github.com/kordamp/pomchecker/"
    ).insert()
}
