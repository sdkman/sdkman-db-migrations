package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "034")
class MavenDaemon {
  @ChangeSet(
    order = "001",
    id = "001_add_mvnd_candidate",
    author = "helpermethod"
  )
  def migration001(implicit db: MongoDatabase): Candidate =
    Candidate(
      candidate = "mvnd",
      name = "Maven Daemon",
      description =
        "The mvnd project aims to provide a daemon infrastructure for maven based builds. It borrows techniques from Gradle and Takari to provide a simple and efficient system.",
      websiteUrl = "https://github.com/mvndaemon/mvnd/"
    ).insert()
}
