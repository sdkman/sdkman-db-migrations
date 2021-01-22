package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "042")
class LayrryMigrations {

  @ChangeSet(
    order = "001",
    id = "001_add_layrry_candidate",
    author = "aalmiray"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "layrry",
      name = "Layrry",
      description =
        "Layrry - A Launcher and API for Modularized Java Applications.",
      websiteUrl = "https://github.com/moditect/layrry/"
    ).insert()
}
