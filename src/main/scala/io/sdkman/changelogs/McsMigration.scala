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
        "Search the Maven Central Repository from your command line!",
      websiteUrl = "https://github.com/mthmulders/mcs"
    ).insert()
}
