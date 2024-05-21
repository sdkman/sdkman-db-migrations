package io.sdkman.changelogs

import com.github.mongobee.changeset.{ChangeLog, ChangeSet}
import com.mongodb.client.MongoDatabase

@ChangeLog(order = "086")
class JustMigrations {
  @ChangeSet(
    order = "001",
    id = "001-add_just_candidate",
    author = "bowbahdoe"
  )
  def migration001(implicit db: MongoDatabase) =
    Candidate(
      candidate = "just",
      name = "Just",
      description = "\uD83E\uDD16 Just a command runner",
      websiteUrl = "https://github.com/casey/just",
      distribution = "PLATFORM_SPECIFIC"
    ).insert()
}
