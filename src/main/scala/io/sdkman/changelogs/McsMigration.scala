package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "065")
class McsMigration {

  @ChangeSet(
    order = "001",
    id = "001_add_mcs_candidate",
    author = "mthmulders"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "mcs",
      name = "MCS",
      description =
        "Search the Maven Central Repository from your command line! Using mcs, you can find artifacts and generate the required pom.xml snippet to use directly in your Maven project.",
      websiteUrl = "https://github.com/mthmulders/mcs"
    ).insert()
}
