package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "086")
class DependencyWatchMigrations {
  @ChangeSet(
    order = "001",
    id = "001_add_dependency_watch_candidate",
    author = "eygraber"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "dependency-watch",
      name = "dependency-watch",
      description =
        "dependency-watch is a script that waits for an artifact to appear in a Maven repository or to monitor coordinates for new versions.",
      websiteUrl = "https://github.com/eygraber/dependency-watch-sdkman"
    ).insert()
}
